# Jogo do Tempero

**Aluno:** Igor – Desenvolvimento de Aplicativos Móveis – Prof. Andre Luis

Quiz feito com **Kotlin + Jetpack Compose**, baseado no app Tempero.
O jogador cria seu **perfil** (nome), escolhe o **nível** (Fácil, Médio ou Difícil) e
responde 4 perguntas: aparece uma **dica** sobre o prato (o emoji fica escondido como ❓
até responder) e ele escolhe a receita entre **5 alternativas**. Cada acerto vale 1 ponto.
No perfil aparecem: **nível do jogador** (sobe a cada 5 pontos), partidas e recorde.
Tem também a tela de **Desafios** (6 conquistas) e um **Ranking online** salvo no **Firebase Firestore**.

## Como rodar
Abra a pasta `TemperoJogo` no Android Studio, espere o Gradle Sync e clique em **Run ▶**.

## Arquivos
| Arquivo | O que faz |
|---|---|
| `MainActivity.kt` | Abre o app e chama `App()` |
| `Pergunta.kt` | `data class Pergunta` (nível, emoji, dica, opções, resposta) + 12 perguntas (4 por nível) |
| `Perfil.kt` | `data class Perfil` (nome, partidas, recorde, pontos) + `nivelJogador` |
| `App.kt` | Guarda o perfil e o nível escolhido e decide qual tela mostrar |
| `TelaPerfil.kt` | Nome, avatar, estatísticas e botões de nível |
| `Desafio.kt` | `data class Desafio` + os 6 desafios (cada um com a regra que diz se foi cumprido) |
| `TelaDesafios.kt` | Lista de desafios com ✅ ou 🔒 |
| `ConfigFirebase.kt` | API key, App ID e Project ID do projeto Firebase |
| `RankingFirebase.kt` | Salva e busca o ranking no Firestore |
| `TelaRanking.kt` | Mostra o top 10 vindo do Firebase |
| `TelaJogo.kt` | A partida: perguntas, pontos, cores dos botões e fim de jogo |

## Como funciona
- `App`: `tela` ("perfil" ou "jogo"), `perfil` e `nivel`, todos com `remember { mutableStateOf() }`.
- O jogo recebe só as perguntas do nível: `perguntas.filter { it.nivel == nivel }`.
- Na partida: `numero` (pergunta atual), `pontos` e `escolhida` (`null` = ainda não respondeu).
- No fim, `aoTerminar(pontos)` atualiza o perfil com `copy()`: +1 partida, recorde e pontos totais.
- `nivelJogador = 1 + pontosTotais / 5`.
- No fim de cada partida, o resultado é salvo no **Firebase Firestore**, na coleção `ranking`.
- O perfil fica na memória: ao fechar o app, ele volta a zero (o ranking continua no Firebase).

## Configurar o Firebase
1. Crie um projeto em console.firebase.google.com.
2. Adicione um app **Android** com o pacote `com.igor.temperojogo`.
3. Em **Firestore Database**, crie o banco no **modo de teste**.
4. Copie a API key, o App ID e o Project ID para `ConfigFirebase.kt`.
