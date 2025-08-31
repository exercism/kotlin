object CarsAssemble {

    fun calculateWorkingCarsPerHour(productionRate : Int, successRate : Double) : Double {
        return productionRate * successRate / 100
    }

    fun calculateWorkingCarsPerMinute(productionRate :  Int, successRate : Double) : Int {
        val result = calculateWorkingCarsPerHour(productionRate, successRate) / 60
        return result.toInt()
    }

    fun calculateProductionCost(carsCount : Int) : ULong {
        val result = (carsCount / 10) * 95_000 +  (carsCount % 10) * 10_000
        return result.toULong()
    }
}
