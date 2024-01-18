package dev.toastcie.mathtoastools.vector

import kotlin.math.sqrt

/**
 * A 3D vector
 * @property x the x value of the vector
 * @property y the y value of the vector
 * @property z the z value of the vector
 * @constructor creates a vector with the given values
 */
data class Vector3(var x: Float, var y: Float, var z: Float) {
    //constructors
    constructor(xy: Vector2, z: Float) : this(xy.x,xy.y,z)

    //editing methods
    /**
     * the normalized vector
     */
    val normalize: Vector3
        get(){
            val len = length
            return Vector3(x / len, y / len, z / len)
        }

    //specials vectors
    /**
     * the x and y values of the vector
     */
    val xy: Vector2
        get() = Vector2(x, y)

    /**
     * the x and z values of the vector
     */
    val xz: Vector2
        get() = Vector2(x, z)

    /**
     * the y and z values of the vector
     */
    val yz: Vector2
        get() = Vector2(y, z)

    //calculations methods
    /**
     * Adds the x and y values of the vector
     * @param other the vector to add
     * @return the new vector
     */
    operator fun plus(other: Vector3): Vector3 = Vector3(x + other.x, y + other.y, z + other.z)
    /**
     * Adds the x and y values of the vector
     * @param other the float to add
     * @return the new vector
     */
    operator fun plus(other: Float): Vector3 = Vector3(x + other, y + other, z + other)

    /**
     * Subtracts the x and y values of the vector
     * @param other the vector to subtract
     * @return the new vector
     */
    operator fun minus(other: Vector3): Vector3 = Vector3(x - other.x, y - other.y, z - other.z)
    /**
     * Subtracts the x and y values of the vector
     * @param other the float to subtract
     * @return the new vector
     */
    operator fun minus(other: Float): Vector3 = Vector3(x - other, y - other, z - other)

    /**
     * multiply the x and y values of the vector
     * @param other the vector to multiply
     * @return the new vector
     */
    operator fun times(other: Vector3): Vector3 = Vector3(
        y * other.z - z * other.y,
        z * other.x - x * other.z,
        x * other.y - y * other.x
    )
    /**
     * multiply the x and y values of the vector
     * @param other the float to multiply
     * @return the new vector
     */
    operator fun times (scalar: Float): Vector3 = Vector3(x * scalar, y * scalar, z * scalar)

    /**
     * dot product of 2 vectors
     * @param other the vector to dot
     * @return the dot product
     */
    infix fun dot(other: Vector3): Float = x * other.x + (y * other.y) + (z * other.z)

    /**
     * mix 2 vectors
     * @param other the vector to mix
     * @param t the mix value
     * @return the mixed vector
     */
    fun mix(other: Vector3, t: Float): Float = x * (1 - t) + (other.x * t) + (y * (1 - t)) + (other.y * t) + (z * (1 - t)) + (other.z * t)

    //data methods
    /**
     * the length of the vector
     */
    val length: Float
            get() = sqrt((x * x + (y * y) + (z * z)))
}