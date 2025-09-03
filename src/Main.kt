fun main() {
    // Requirement 1: Create and Populate Collections
    val studentNames: List<String> = listOf("Ahmed", "Laila", "Nour", "Hassan", "Mona")

    val mutableStudentNames: MutableList<String> = mutableListOf("Ali", "Sara")
    mutableStudentNames.add("Khaled")

    val studentScores: Map<String, Int> = mapOf(
        "Ahmed" to 85,
        "Laila" to 72,
        "Nour" to 95,
        "Hassan" to 60,
        "Mona" to 45
    )

    val graduatedStudents: Set<String> = setOf("Hassan", "Mona")

    println("=== Requirement 1 Output ===")
    println("Student Names: $studentNames")
    println("Mutable Student Names: $mutableStudentNames")
    println("Student Scores: $studentScores")
    println("Graduated Students: $graduatedStudents\n")

    // Requirement 2: Looping and Searching
    println("=== Requirement 2 Output ===")

    studentNames.forEach { name ->
        if (name !in graduatedStudents) {
            val score = studentScores[name]
            println("Active Student: $name, Score: $score")
        }
    }

    val searchName = "Nour"
    val foundScore = studentScores[searchName]
    println("Score of $searchName: $foundScore\n")

    // Requirement 3: Transforming and Filtering
    println("=== Requirement 3 Output ===")

    val upperCaseNames = studentNames.map { it.uppercase() }
    println("Uppercase Names: $upperCaseNames")

    val highScorers = studentScores.filter { it.value > 80 }.map { it.key }
    println("High Scorers (>80): $highScorers")

    println("Chained Operations (filter→map→forEach):")
    studentScores.filter { it.value > 80 }
        .map { "${it.key.uppercase()} - ${it.value}" }
        .forEach { println(it) }
    println()

    // Requirement 4: Reducing and Aggregation
    println("=== Requirement 4 Output ===")

    val totalScore = studentScores.values.reduce { acc, score -> acc + score }
    println("Total Score (reduce): $totalScore")

    val formattedString = studentScores.entries.fold("") { acc, entry ->
        if (acc.isEmpty()) "${entry.key}: ${entry.value}"
        else "$acc | ${entry.key}: ${entry.value}"
    }
    println("Formatted String (fold): $formattedString\n")

    // Requirement 5: Student Report Generation
    println("=== Requirement 5 Output ===")
    val varOcg = studentScores

    generateStudentReport(varOcg)
}

// Function for Requirement 5
fun generateStudentReport(scores: Map<String, Int>) {
    if (scores.isEmpty()) {
        println("No student data available.")
        return
    }

    scores.filter { it.value >= 60 }
        .map { "${it.key}: ${it.value}" }
        .forEach { println(it) }
}
