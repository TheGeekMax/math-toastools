package dev.toastcie.mathtoastools.vector.intvector

import kotlin.math.sqrt

/**
 * A 4D vector with integer values
 * @property x the x value of the vector
 * @property y the y value of the vector
 * @property z the z value of the vector
 * @property w the w value of the vector
 * @constructor creates a vector with the given values
 * @constructor creates a vector with the given values
 * @constructor creates a vector with the given values
 */
data class Vector4Int(var x:Int, var y:Int, var z:Int, var w:Int) {
    //constructors
    constructor(xy: Vector2Int, z: Int, w: Int) : this(xy.x, xy.y, z, w)

    constructor(xyz: Vector3Int, w: Int) : this(xyz.x, xyz.y, xyz.z, w)

    constructor(xy: Vector2Int, zw: Vector2Int) : this(xy.x, xy.y, zw.x, zw.y)

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
     * The x and w values of the vector
     */
    val xw: Vector2Int
        get() = Vector2Int(x, w)

    /**
     * The y and z values of the vector
     */
    val yz: Vector2Int
        get() = Vector2Int(y, z)

    /**
     * The y and w values of the vector
     */
    val yw: Vector2Int
        get() = Vector2Int(y, w)

    /**
     * The z and w values of the vector
     */
    val zw: Vector2Int
        get() = Vector2Int(z, w)

    /**
     * The x, y and z values of the vector
     */
    val xyz: Vector3Int
        get() = Vector3Int(x, y, z)

    /**
     * The x, y and w values of the vector
     */
    val xyw: Vector3Int
        get() = Vector3Int(x, y, w)

    /**
     * The x, z and w values of the vector
     */
    val xzw: Vector3Int
        get() = Vector3Int(x, z, w)

    /**
     * The y, z and w values of the vector
     */
    val yzw: Vector3Int
        get() = Vector3Int(y, z, w)

    //calculations methods
    /**
     * Adds two vectors
     * @param other the vector to add
     * @return the sum of the two vectors
     */
    operator fun plus(other: Vector4Int): Vector4Int = Vector4Int(x + other.x, y + other.y, z + other.z, w + other.w)
    /**
     * Adds a scalar to the vector
     * @param other the scalar to add
     * @return the sum of the vector and the scalar
     */
    operator fun plus(other: Int): Vector4Int = Vector4Int(x + other, y + other, z + other, w + other)

    /**
     * Subtracts two vectors
     * @param other the vector to subtract
     * @return the difference of the two vectors
     */
    operator fun minus(other: Vector4Int): Vector4Int = Vector4Int(x - other.x, y - other.y, z - other.z, w - other.w)
    /**
     * Subtracts a scalar to the vector
     * @param other the scalar to subtract
     * @return the difference of the vector and the scalar
     */
    operator fun minus(other: Int): Vector4Int = Vector4Int(x - other, y - other, z - other, w - other)

    /**
     * multiply a vectors by a scalar
     * @param other the scalar to multiply
     * @return the multiplication of the vector and the scalar
     */
    operator fun times(other: Int): Vector4Int = Vector4Int(x * other, y * other, z * other, w * other)

    /**
     * dot product of two vectors
     *
     * @param other the vector to dot
     * @return the dot product of the two vectors
     */
    infix fun dot(other: Vector4Int): Int = x * other.x + (y * other.y) + (z * other.z) + (w * other.w)
}