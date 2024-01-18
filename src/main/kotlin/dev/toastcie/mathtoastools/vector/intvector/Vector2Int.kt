package dev.toastcie.mathtoastools.vector.intvector

import kotlin.math.sqrt

/**
 *  Represents a 2D vector with integer values
 *
 * @property x the x value of the vector
 * @property y the y value of the vector
 */
data class Vector2Int(var x: Int, var y: Int) {

    //calculations methods
    /**
     * Adds two vectors together
     *
     * @param other the vector to add
     * @return the sum of the two vectors
     */
    operator fun plus(other: Vector2Int): Vector2Int = Vector2Int(x + other.x, y + other.y)
    /**
     * Adds a value to each component of the vector
     *
     * @param other the value to add
     * @return the sum of the vector and the value
     */
    operator fun plus(other: Int): Vector2Int = Vector2Int(x + other, y + other)

    /**
     * Subtracts two vectors
     *
     * @param other the vector to subtract
     * @return the difference of the two vectors
     */
    operator fun minus(other: Vector2Int): Vector2Int = Vector2Int(x - other.x, y - other.y)
    /**
     * Subtracts a value to each component of the vector
     *
     * @param other the value to subtract
     * @return the difference of the vector and the value
     */
    operator fun minus(other: Int): Vector2Int = Vector2Int(x - other, y - other)

    /**
     * Multiplies two vectors
     *
     * @param other the vector to multiply
     * @return the product of the two vectors
     */
    operator fun times(other: Vector2Int): Vector2Int = Vector2Int(x * other.y, y * other.x)
    /**
     * Multiplies a value to each component of the vector
     *
     * @param other the value to multiply
     * @return the product of the vector and the value
     */
    operator fun times(other: Int): Vector2Int = Vector2Int(x * other, y * other)

    /**
     * Divides two vectors
     *
     * @param other the vector to divide
     * @return the quotient of the two vectors
     */
    infix fun dot(other: Vector2Int): Int = x * other.x + y * other.y

    //data methods
}