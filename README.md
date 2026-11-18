# Jogo do Tempero

**Aluno:** Igor – Desenvolvimento de Aplicativos Móveis – Prof. Andre Luis

Quiz simples feito com **Kotlin + Jetpack Compose**, baseado no app Tempero:
aparece o emoji de um prato e os ingredientes, e o jogador escolhe qual é a receita
entre 5 alternativas. Cada acerto vale 1 ponto. No fim mostra a pontuação e dá para jogar de novo.

## Como rodar
Abra a pasta `TemperoJogo` no Android Studio, espere o Gradle Sync e clique em **Run ▶**.

## Arquivos
| Arquivo | O que faz |
|---|---|
| `MainActivity.kt` | Abre o app e chama a `TelaJogo()` |
| `Pergunta.kt` | `data class Pergunta` + a lista com 12 perguntas |
| `TelaJogo.kt` | A tela: estado com `remember { mutableStateOf() }`, `Column`, `Text` e `Button` |

## Como funciona
- `numero`: em qual pergunta o jogador está.
- `pontos`: quantos acertos.
- `escolhida`: qual opção ele tocou (`null` = ainda não respondeu).

Quando um desses valores muda, o Compose redesenha a tela sozinho.
Ao tocar numa opção: se for a certa, soma 1 ponto; o botão certo fica verde e o errado vermelho.
"Próxima" avança (`numero++`). Quando `numero` chega ao total, aparece a tela de fim de jogo.
