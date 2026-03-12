# Lab 8 — Observer & MVC: Sistema de Assentos de Rodoviária

## Problema proposto

Implementar um sistema para uma rodoviária que disponibiliza as informações sobre os assentos de um determinado ônibus (disponível, reservado, indisponível) no **painel central** da rodoviária e em **quiosques** espalhados pelo terminal. Sempre que um cliente se dirige ao guichê e compra ou reserva uma passagem, o painel e os quiosques são atualizados automaticamente.

- **Painel central**: exibe a grade de 48 poltronas colorida (verde = disponível, amarelo = reservado, vermelho = vendido).
- **Quiosque**: exibe a listagem numerada de cada poltrona e seu status em formato de tabela.

---

## Arquitetura: MVC + Observer

Os dois padrões foram combinados de forma complementar:

- **MVC** organiza as responsabilidades em camadas (Model, View, Controller), separando regras de negócio da interface e da lógica de controle.
- **Observer** resolve o problema de notificação: sempre que o Model muda, as Views são avisadas automaticamente, sem que o Model precise conhecer nenhuma delas diretamente.

A seguir, cada camada e cada papel do Observer são explicados em detalhe.

---

## Estrutura de pacotes e classes

```
src/
├── App.java                         ← ponto de entrada (main)
├── controller/
│   └── guicheController.java        ← Controller (MVC)
├── event/
│   ├── AssentoEvent.java            ← Event (Observer)
│   └── AssentoListener.java         ← Listener/interface (Observer)
├── model/
│   ├── Assento.java                 ← entidade de domínio
│   ├── Onibus.java                  ← Model + Source (Observer)
│   └── StatusAssento.java           ← enum de estados
└── view/
    ├── PainelDeControle.java        ← View + Observer concreto
    └── Quiosque.java                ← View + Observer concreto
```

---

## Camada Model

### `StatusAssento` (enum)
Define os três estados possíveis de uma poltrona:

| Valor | Significado |
|---|---|
| `Disponivel` | Assento livre para compra ou reserva |
| `Reservado` | Assento reservado, ainda não pago |
| `Vendido` | Passagem vendida (assento ocupado) |

### `Assento`
Representa uma poltrona individual. Possui:
- `numIdentificador` — número da poltrona (1 a 48).
- `status` — estado atual (`StatusAssento`).
- Inicializado sempre como `Disponivel`.

### `Onibus` — Model e Source do Observer
É o núcleo do sistema. Responsabilidades:

1. **Domínio**: mantém o array de 48 `Assento`s com as regras de negócio (`reservarAssento`, `venderAssento`).
2. **Source do Observer**: mantém a lista de `AssentoListener`s registrados e os notifica via `notifyListeners` sempre que uma poltrona é alterada.

```
Onibus
 ├── Assento[48]                  ← estado interno
 ├── List<AssentoListener>        ← lista de observers
 ├── addAssentoListener(l)
 ├── removeAssentoListener(l)
 ├── reservarAssento(n)  ──→ valida → muda status → notifyListeners
 └── venderAssento(n)    ──→ valida → muda status → notifyListeners
```

**Regras de negócio:**
- Só é possível **reservar** uma poltrona `Disponivel`.
- É possível **vender** uma poltrona `Disponivel` ou `Reservada` (conversão direta).
- Operações inválidas exibem aviso sem lançar exceção.

---

## Camada Event

### `AssentoEvent` — Evento do Observer
Criado pelo `Onibus` a cada mudança e passado a todos os listeners. Encapsula:

- `assentoAlterado` — a poltrona que mudou de estado.
- `todasPoltronas` — referência ao array completo, para que os observers possam re-renderizar a visão inteira.

Herda de `java.util.EventObject`, seguindo a convenção JavaBeans de eventos.

### `AssentoListener` — Interface do Observer
Interface que todo observer deve implementar:

```java
public interface AssentoListener extends EventListener {
    void assentoAtualizado(AssentoEvent event);
}
```

Herda de `java.util.EventListener` (marker interface padrão Java).

---

## Camada View

Ambas as views implementam `AssentoListener` e são registradas no `Onibus`. Não guardam estado próprio — apenas re-renderizam ao receber o evento.

### `PainelDeControle` — Observer concreto
Exibe a grade de 48 poltronas colorida com códigos ANSI:

- 🟢 **Verde** → `Disponivel`
- 🟡 **Amarelo** → `Reservado`
- 🔴 **Vermelho** → `Vendido`

As poltronas ficam dispostas em 4 colunas (12 linhas), simulando a disposição física do ônibus.

### `Quiosque` — Observer concreto
Cada quiosque possui um nome identificador (ex.: "Terminal A"). Exibe a listagem completa em formato de tabela com número e status de cada poltrona.

---

## Camada Controller

### `guicheController`
Recebe as ações do atendente do guichê e as delega ao Model (`Onibus`). É a única classe que conhece tanto o Model quanto as operações disponíveis nele — as Views não são acionadas diretamente pelo Controller; elas são notificadas pelo Model via Observer.

```java
guicheController
 ├── reservarAssento(n) ──→ onibus.reservarAssento(n)
 └── comprarAssento(n)  ──→ onibus.venderAssento(n)
```

---

## Como MVC e Observer conversam

```
  [Atendente]
       │
       ▼
[guicheController]  ← Controller (MVC)
       │
       │ chama reservarAssento(n) / venderAssento(n)
       ▼
   [Onibus]          ← Model (MVC) + Source (Observer)
       │
       │ 1. altera Assento[n].status
       │ 2. cria AssentoEvent
       │ 3. itera sobre List<AssentoListener> e chama assentoAtualizado(event)
       │
       ├──────────────────────────────────┐
       ▼                                  ▼
[PainelDeControle]              [Quiosque(s)]
   View (MVC)                    View (MVC)
   Observer concreto             Observer concreto
       │                                  │
  Exibe grade colorida           Exibe listagem numerada
```

**Por que os dois padrões juntos?**

- O MVC garante que a lógica de negócio (`Onibus`) não depende da interface gráfica, e que o Controller não "sabe" como as telas são renderizadas.
- O Observer garante que podem existir **zero, um ou muitos** quiosques e painéis registrados sem que o `Onibus` precise ser modificado. Bastaria chamar `addAssentoListener` com uma nova view.
- Esse desacoplamento é o principal benefício: Model não conhece View, View não conhece Model diretamente, e o Controller apenas orquestra a intenção do usuário.

---

## Fluxo completo de uma operação

Exemplo: cliente compra a passagem para o assento 12.

```
1. Atendente → guicheController.comprarAssento(12)
2. Controller → onibus.venderAssento(12)
3. Onibus:
   a. Valida: assento 12 não é Vendido → OK
   b. assento[11].setStatus(Vendido)
   c. Cria: new AssentoEvent(this, assento12, poltronas[])
   d. Para cada listener na lista:
        listener.assentoAtualizado(event)
4. PainelDeControle.assentoAtualizado(event):
   - Imprime cabeçalho com assento alterado
   - Percorre todas as 48 poltronas e imprime cada uma na cor correspondente
5. Quiosque("Terminal A").assentoAtualizado(event):
   - Imprime tabela de 48 linhas com número e status de cada poltrona
6. Quiosque("Terminal B").assentoAtualizado(event):
   - Idem
```

---

## Como compilar e executar

```bash
# Na raiz do projeto
javac -d bin -sourcepath src src/App.java src/model/*.java src/event/*.java src/view/*.java src/controller/*.java

java -cp bin App
```

---

## Cenários de teste cobertos em `App.java`

| Cenário | Operação | Resultado esperado |
|---|---|---|
| 1 | Reservar assento 5 (disponível) | Status → Reservado; observers notificados |
| 2 | Comprar assento 12 (disponível) | Status → Vendido; observers notificados |
| 3 | Comprar assento 5 (reservado) | Status → Vendido; conversão direta; notificado |
| 4 | Reservar assento 12 (vendido) | Aviso: não disponível; estado não muda |
| 5 | Comprar assento 48 (disponível) | Status → Vendido; observers notificados |

---

## Conceitos avaliados

| Critério | Implementação |
|---|---|
| **30% — Pacotes (Model/View/Controller)** | `model`, `view`, `controller` e `event` bem separados, sem dependências invertidas |
| **40% — Observer (Source, Listener, Event)** | `Onibus` como Source, `AssentoListener` como interface, `AssentoEvent` como evento, `PainelDeControle` e `Quiosque` como observers concretos |
| **10% — Main** | `App.java` monta o sistema, registra observers e demonstra todos os cenários |
| **20% — Testes** | 5 cenários em `main` cobrem operações válidas e inválidas |
