data class Player(val name: String)

data class Match(val player1: Player, val player2: Player)

fun main() {
    var participants = mutableListOf(
            Player("Talha"),
            Player("Furkan"),
            Player("Nino"),
            Player("Fabiano"),
            Player("Hasan"),
            Player("Andreas"),
            Player("Elo"),
            Player("Alihan"),
            Player("Oemer"),
            Player("Minh"),
            Player("Emre"),
            Player("Devran"),
            Player("Jan")
    )


    val rounds = 5
    var i = 1
    val matchesPerRound = participants.size / 2
    var wildcards = mutableListOf<Player>()

    val scores = mutableMapOf<Player, Int>(
            Player("Talha") to 0,
            Player("Furkan") to 0,
            Player("Nino") to 0,
            Player("Fabiano") to 0,
            Player("Hasan") to 0,
            Player("Andreas") to 0,
            Player("Elo") to 0,
            Player("Alihan") to 0,
            Player("Oemer") to 0,
            Player("Minh") to 0,
            Player("Emre") to 0,
            Player("Devran") to 0,
            Player("Jan") to 0
    )


    val initialPairings = mutableListOf<Match>()
    while (i <= rounds){
        for (x in 0 until matchesPerRound){
            var randomplayer1 = participants.random()
            participants.remove(randomplayer1)
            var randomplayer2 = participants.random()
            participants.remove(randomplayer2)
            initialPairings.add(Match(randomplayer1, randomplayer2))
            println("In der $i. Runde Spielen folgende 2 Gegeneinander: ${initialPairings[x].player1.name} VS ${initialPairings[x].player2.name}")
        }
        println("Wildcard diese Runde ist bei ${participants.first().name}")
        wildcards.add(participants.first())


        for (x in 0 until matchesPerRound){
            println("Wer hat bei ${initialPairings[x].player1.name} VS ${initialPairings[x].player2.name} gewonnen? (1 / 2 / unentschieden = 3)")
            var ergebnis = readln().toInt()
            println("Zu was hat er gewonnen? (1 zu Null/ 2 zu Eins / unentschieden = 3)")
            var zwischenergebnis = readln().toInt()
            when(ergebnis){
                3 -> {
                    scores[initialPairings[x].player1] = scores[initialPairings[x].player1]!! + 1
                    scores[initialPairings[x].player2] = scores[initialPairings[x].player2]!! + 1
                }
                1 -> {
                    when(zwischenergebnis){
                        1 -> {
                            scores[initialPairings[x].player1] = scores[initialPairings[x].player1]!! + 3
                        }
                        2 -> {
                            scores[initialPairings[x].player1] = scores[initialPairings[x].player1]!! + 2
                        }
                    }
                }
                2 -> {
                    when(zwischenergebnis){
                        1 -> {
                            scores[initialPairings[x].player2] = scores[initialPairings[x].player2]!! + 3
                        }
                        2 -> {
                            scores[initialPairings[x].player2] = scores[initialPairings[x].player2]!! + 2
                        }
                    }
                }
            }

        }

        i++
        initialPairings.clear()

        participants = mutableListOf(
                Player("Talha"),
                Player("Furkan"),
                Player("Nino"),
                Player("Fabiano"),
                Player("Hasan"),
                Player("Andreas"),
                Player("Elo"),
                Player("Alihan"),
                Player("Oemer"),
                Player("Minh"),
                Player("Emre"),
                Player("Devran"),
                Player("Jan")
        )
    }
    // Print final scores
    println("Final scores:")
    for (participant in participants) {
        println("${participant.name}: ${scores.getValue(participant)} points")
    }
}
