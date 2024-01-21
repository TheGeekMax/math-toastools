package dev.toastcie.mathtoastools.vector.intvector

import kotlin.math.sqrt

/**
 * A 3D vector with integer values
 * @property x the x value of the vector
 * @property y the y value of the vector
 * @property z the z value of the vector
 * @constructor creates a vector with the given values
 * @see Vector2Int
 */
data class Vector3Int(var x: Int, var y: Int, var z: Int) {
    //constructors
    constructor(xy: Vector2Int, z: Int) : this(xy.x,xy.y,z)

    //editing methods

    //specials vectors
    /**
     * The x and y values of the vector
     */
    val xy: Vector2Int
        get() = Vector2Int(x, y)

    /**
     * The x and z values of the vector
     */
    val xz: Vector2Int
        get() = Vector2Int(x, z)

    /**
     * The y and z values of the vector
     */
    val yz: Vector2Int
        get() = Vector2Int(y, z)

    //calculations methods
    /**
     * Adds two vectors
     * @param other the vector to add
     * @return the sum of the two vectors
     */
    operator fun plus(other: Vector3Int): Vector3Int = Vector3Int(x + other.x, y + other.y, z + other.z)
    /**
     * Adds a scalar to the vector
     * @param other the scalar to add
     * @return the sum of the vector and the scalar
     */
    operator fun plus(other: Int): Vector3Int = Vector3Int(x + other, y + other, z + other)

    /**
     * Subtracts two vectors
     * @param other the vector to subtract
     * @return the difference of the two vectors
     */
    operator fun minus(other: Vector3Int): Vector3Int = Vector3Int(x - other.x, y - other.y, z - other.z)
    /**
     * Subtracts a scalar to the vector
     * @param other the scalar to subtract
     * @return the difference of the vector and the scalar
     */
    operator fun minus(other: Int): Vector3Int = Vector3Int(x - other, y - other, z - other)

    /**
     * multiply two vectors
     * @param other the vector to divide
     * @return the quotient of the two vectors
     */
    operator fun times(other: Vector3Int): Vector3Int = Vector3Int(
        y * other.z - z * other.y,
        z * other.x - x * other.z,
        x * other.y - y * other.x
    )

    /**
     * multiply a vector by a scalar
     * @param scalar the scalar to divide
     * @return the quotient of the vector and the scalar
     */
    operator fun times (scalar: Int): Vector3Int = Vector3Int(x * scalar, y * scalar, z * scalar)

    /**
     * dot product of two vectors
     *
     * @param other the vector to dot
     * @return the dot product of the two vectors
     */
    infix fun dot(other: Vector3Int): Int = x * other.x + (y * other.y) + (z * other.z)

}