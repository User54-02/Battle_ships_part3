// Оставляем функцию печати двух полей
fun printBothFields(player: Player, enemy: Player) {
    println("=== Поле игрока ${player.name} ===          === Поле игрока ${enemy.name} ===")
    print("  ")
    for (c in 0..9) print("$c ")
    print("        ")
    for (c in 0..9) print("$c ")
    println()
    for (r in 0..9) {
        print("$r ")
        for (c in 0..9) print("${player.field()[r][c]} ")
        print("        ")
        print("$r ")
        for (c in 0..9) print("${enemy.field()[r][c]} ")
        println()
    }
}

fun main() {
    // Задание 5: Создание через конструктор
    val player = Player("Вы")
    val enemy = Player("Компьютер")

    // Задание 5: Ставим корабли через placeShip
    player.placeShip(3, 2)
    player.placeShip(3, 3)
    player.placeShip(3, 4)
    player.placeShip(3, 5)

    enemy.placeShip(5, 7)
    enemy.placeShip(6, 7)
    enemy.placeShip(7, 7)

    // Задание 5: Регистрируем выстрелы через registerShot
    player.registerShot(true)
    player.registerShot(false)
    player.registerShot(true)

    // Задание 6: Проверка markShot
    enemy.markShot(3, 3, true)  // Попал в наш корабль
    enemy.markShot(4, 4, false) // Промахнулся

    printBothFields(player, enemy)
    println()

    // Задание 5: Чтение статистики через get-еры
    println("Выстрелов: ${player.shots}")
    println("Попаданий: ${player.hits}")
    println(player.status())

    // Задание 5: Закомментированные строки (проверка защиты)

    // val p2 = Player() // Ошибка: нет аргумента name
    // player.name = "Другой" // Ошибка: val нельзя изменить
    // player.shots = 100 // Ошибка: val нельзя изменить
    // player.field[3][2] = '#' // Ошибка: поле приватное, доступ только через методы
}