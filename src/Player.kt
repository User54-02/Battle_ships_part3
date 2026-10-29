class Player(val name: String) { // Задание 1: name в конструкторе

    // Задание 4: Приватное поле
    private val _field: Array<CharArray> = Array(10) { CharArray(10) { '.' } }
    // Get-ер для поля
    fun field(): Array<CharArray> = _field
    // Задание 2: Приватные счётчики
    private var _shots: Int = 0
    private var _hits: Int = 0
    // Get-еры для счётчиков
    val shots: Int
        get() = _shots
    val hits: Int
        get() = _hits
    // Задание 3: Set-ер для статистики
    fun registerShot(hit: Boolean) {
        _shots++
        if (hit) _hits++
    }
    // Задание 4: Set-ер для установки корабля
    fun placeShip(row: Int, col: Int) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = '#'
        }
    }
    // Задание 6: Set-ер для отметки выстрела
    fun markShot(row: Int, col: Int, hit: Boolean) {
        if (row in 0..9 && col in 0..9) {
            _field[row][col] = if (hit) 'X' else '0'
        }
    }
    fun status(): String {
        val acc = String.format("%.1f", if (_shots == 0) 0.0 else _hits * 100.0 / _shots)
        return "Игрок $name: выстрелов $_shots, попаданий $_hits, точность $acc%"
    }
}