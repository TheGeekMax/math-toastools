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
    var xy: Vector2Int
        get() = Vector2Int(x, y)
        set(value) {
            x = value.x
            y = value.y
        }

    /**
     * The x and z values of the vector
     */
    var xz: Vector2Int
        get() = Vector2Int(x, z)
        set(value) {
            x = value.x
            z = value.y
        }

    /**
     * The x and w values of the vector
     */
    var xw: Vector2Int
        get() = Vector2Int(x, w)
        set(value) {
            x = value.x
            w = value.y
        }

    /**
     * The y and z values of the vector
     */
    var yz: Vector2Int
        get() = Vector2Int(y, z)
        set(value) {
            y = value.x
            z = value.y
        }

    /**
     * The y and w values of the vector
     */
    var yw: Vector2Int
        get() = Vector2Int(y, w)
        set(value) {
            y = value.x
            w = value.y
        }

    /**
     * The z and w values of the vector
     */
    var zw: Vector2Int
        get() = Vector2Int(z, w)
        set(value) {
            z = value.x
            w = value.y
        }

    /**
     * The x, y and z values of the vector
     */
    var xyz: Vector3Int
        get() = Vector3Int(x, y, z)
        set(value) {
            x = value.x
            y = value.y
            z = value.z
        }

    /**
     * The x, y and w values of the vector
     */
    var xyw: Vector3Int
        get() = Vector3Int(x, y, w)
        set(value) {
            x = value.x
            y = value.y
            w = value.z
        }

    /**
     * The x, z and w values of the vector
     */
    var xzw: Vector3Int
        get() = Vector3Int(x, z, w)
        set(value) {
            x = value.x
            z = value.y
            w = value.z
        }

    /**
     * The y, z and w values of the vector
     */
    var yzw: Vector3Int
        get() = Vector3Int(y, z, w)
        set(value) {
            y = value.x
            z = value.y
            w = value.z
        }

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