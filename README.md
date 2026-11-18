# Jogo do Tempero

**Aluno:** Igor – Desenvolvimento de Aplicativos Móveis – Prof. Andre Luis

Quiz feito com **Kotlin + Jetpack Compose**, baseado no app Tempero.
O jogador cria seu **perfil** (nome), escolhe o **nível** (Fácil, Médio ou Difícil) e
responde 4 perguntas: aparece o emoji de um prato e os ingredientes, e ele escolhe a
receita entre **5 alternativas**. Cada acerto vale 1 ponto.
No perfil aparecem: **nível do jogador** (sobe a cada 5 pontos), partidas e recorde.

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
| `TelaJogo.kt` | A partida: perguntas, pontos, cores dos botões e fim de jogo |

## Como funciona
- `App`: `tela` ("perfil" ou "jogo"), `perfil` e `nivel`, todos com `remember { mutableStateOf() }`.
- O jogo recebe só as perguntas do nível: `perguntas.filter { it.nivel == nivel }`.
- Na partida: `numero` (pergunta atual), `pontos` e `escolhida` (`null` = ainda não respondeu).
- No fim, `aoTerminar(pontos)` atualiza o perfil com `copy()`: +1 partida, recorde e pontos totais.
- `nivelJogador = 1 + pontosTotais / 5`.
- Os dados ficam na memória (sem banco): ao fechar o app, o perfil volta a zero.
