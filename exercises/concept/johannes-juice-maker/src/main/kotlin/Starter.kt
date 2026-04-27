/**
 * Represents a starter, a device that helps to start the juice maker.
 * Needs to be installed in the juice maker by calling its install method.
 *
 * NOTE: There is no need to change this file and is treated as read only by the Exercism test runners.
 */
class Starter {
    private var installed = false

    fun install() {
        installed = true
    }

    fun isInstalled() : Boolean {
        return installed
    }
}
