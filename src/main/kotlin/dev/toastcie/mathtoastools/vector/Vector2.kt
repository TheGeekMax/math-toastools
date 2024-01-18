package dev.toastcie.mathtoastools.vector

import kotlin.math.sqrt

/**
 * A 2D vector
 * @property x the x value of the vector
 * @property y the y value of the vector
 */
data class Vector2(var x: Float, var y: Float) {
    //editing methods
    /**
     * the normalized vector
     */
    val normalized: Vector2
        get(){
            val len = length
            return Vector2(x / len, y / len)
        }

    //calculations methods
    /**
     * Adds the x and y values of the vector
     * @param other the vector to add
     * @return the new vector
     */
    operator fun plus(other: Vector2): Vector2 = Vector2(x + other.x, y + other.y)
    /**
     * Adds the x and y values of the vector
     * @param other the float to add
     * @return the new vector
     */
    operator fun plus(other: Float): Vector2 = Vector2(x + other, y + other)

    /**
     * Subtracts the x and y values of the vector
     * @param other the vector to subtract
     * @return the new vector
     */
    operator fun minus(other: Vector2): Vector2 = Vector2(x - other.x, y - other.y)
    /**
     * Subtracts the x and y values of the vector
     * @param other the float to subtract
     * @return the new vector
     */
    operator fun minus(other: Float): Vector2 = Vector2(x - other, y - other)

    /**
     * multiply the x and y values of the vector
     * @param other the vector to multiply
     * @return the new vector
     */
    operator fun times(other: Vector2): Vector2 = Vector2(x * other.y, y * other.x)
    /**
     * multiply the x and y values of the vector
     * @param other the float to multiply
     * @return the new vector
     */
    operator fun times(other: Float): Vector2 = Vector2(x * other, y * other)

    /**
     * dot product of 2 vectors
     * @param other the vector to dot
     * @return the dot product
     */
    infix fun dot(other: Vector2): Float = x * other.x + y * other.y
    /**
     * cross product of 2 vectors
     * @param other the vector to cross
     * @return the cross product
     */
    fun mix(other: Vector2, t: Float): Float = x * (1 - t) + (other.x * t) + (y * (1 - t)) + (other.y * t)

    //data methods
    /**
     * the length of the vector
     */
    val length: Float
        get() = sqrt(x * x + y * y).toFloat()
}