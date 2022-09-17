// Размер колоды

const val DECK_SIZE = 36

// Масть

enum class Suit {

    diamonds, hearts, clubs, spades

}

// Значение

enum class Rank (val value: Int){

    six(1), seven(2), eight(3), nine(4), ten(5), jack(6), queen(7), king(8), ace(9)

}

// Карта

data class Card(val Rank: String, val Suit: String) {

    val type = Suit

    val num = Rank

}

val allrank = listOf("six", "seven", "eight", "nine", "ten", "jack", "queen", "king", "ace")

val allcard = listOf("diamonds", "hearts", "clubs", "spades")

// Тип для обозначения игрока (первый, второй)

enum class Player {

    first, second

}

// Возвращается null, если значения карт совпадают

fun roundWinner(card1: Card, card2 : Card): Player? {

    if (card1.Rank==card2.Rank) {

        null

    } else if (card1.Rank<card2.Rank) {

        Player.second

    } else {

        Player.first

    }

}

// Колода

typealias Deck = List<Card>

// Набор карт у игрока

typealias Hand = MutableList<Card>

// Набор карт, выложенных на стол

typealias Table = MutableList<Card>

// Наборы карт у игроков

typealias Hands = Map<Player, Hand>

// Возвращает полную колоду (36 карт) в фиксированном порядке

fun fullDeck() : Deck {

    var k: List<Card> = emptyList()

    for (i in allrank)

        for (j in allcard)

            k+= Card(i, j)

    return k

}

// Раздача карт: случайное перемешивание (shuffle) и деление колоды пополам

fun deal(deck: Deck) : Hands {

    deck.shuffled()

    var hand1: Hand

    var hand2: Hand

    for (i in 1..deck.size)

        if (i%2==1) {

            hand1+=deck[i-1]

        } else {

            hand2+=deck[i-1]

        }

}

// Один раунд игры (в том числе спор при равных картах).

// Возвращается победитель раунда и набор карт, выложенных на стол.

fun round(hands: Hands): Pair<Player, Table> {

    TODO()

}

// Полный цикл игры (возвращается победивший игрок)

// в процессе игры печатаются ходы

fun game(hands: Hands): Player {

    TODO()

}

fun main() {

    val deck = fullDeck()

    val hands = deal(deck) // Подумайте, почему val?

    val winner = game(hands)

    println("Победитель: $winner")

}
