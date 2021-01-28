fun canFastAttack(knightIsAwake: Boolean): Boolean =
    !knightIsAwake

fun canSpy(
    knightIsAwake: Boolean,
    archerIsAwake: Boolean,
    prisonerIsAwake: Boolean
): Boolean =
    knightIsAwake || archerIsAwake || prisonerIsAwake

fun canSignalPrisoner(archerIsAwake: Boolean, prisonerIsAwake: Boolean): Boolean =
    !archerIsAwake && prisonerIsAwake

fun canFreePrisoner(
    knightIsAwake: Boolean,
    archerIsAwake: Boolean,
    prisonerIsAwake: Boolean,
    petDogIsPresent: Boolean
): Boolean =
    !knightIsAwake &&
        !archerIsAwake &&
        prisonerIsAwake || !archerIsAwake &&
        petDogIsPresent
