package dev.toastcie.mathtoastools.vector

import kotlin.math.sqrt

/**
 * A 4D vector
 * @property x the x value of the vector
 * @property y the y value of the vector
 * @property z the z value of the vector
 * @property w the w value of the vector
 * @constructor creates a vector with the given values
 * @constructor creates a vector with the given values
 * @constructor creates a vector with the given values
 * @see Vector2
 * @see Vector3
 */
data class Vector4(var x:Float, var y:Float, var z:Float, var w:Float) {
    //constructors
    constructor(xy: Vector2, z: Float, w: Float) : this(xy.x, xy.y, z, w)

    constructor(xyz: Vector3, w: Float) : this(xyz.x, xyz.y, xyz.z, w)

    constructor(xy: Vector2, zw: Vector2) : this(xy.x, xy.y, zw.x, zw.y)

    //editing methods
    /**
     * the normalized vector
     */
    val normalize: Vector4
        get(){
            val len = length
            return Vector4(x / len, y / len, z / len, w / len)
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
     * the x and w values of the vector
     */
    val xw: Vector2
        get() = Vector2(x, w)

    /**
     * the y and z values of the vector
     */
    val yz: Vector2
        get() = Vector2(y, z)

    /**
     * the y and w values of the vector
     */
    val yw: Vector2
        get() = Vector2(y, w)

    /**
     * the z and w values of the vector
     */
    val zw: Vector2
        get() = Vector2(z, w)

    /**
     * the x, y and z values of the vector
     */
    val xyz: Vector3
        get() = Vector3(x, y, z)

    /**
     * the x, y and w values of the vector
     */
    val xyw: Vector3
        get() = Vector3(x, y, w)

    /**
     * the x, z and w values of the vector
     */
    val xzw: Vector3
        get() = Vector3(x, z, w)

    /**
     * the y, z and w values of the vector
     */
    val yzw: Vector3
        get() = Vector3(y, z, w)

    //calculations methods
    /**
     * Adds the x and y values of the vector
     * @param other the vector to add
     * @return the new vector
     */
    operator fun plus(other: Vector4): Vector4 = Vector4(x + other.x, y + other.y, z + other.z, w + other.w)
    /**
     * Adds the x and y values of the vector
     * @param other the float to add
     * @return the new vector
     */
    operator fun plus(other: Float): Vector4 = Vector4(x + other, y + other, z + other, w + other)

    /**
     * Subtracts the x and y values of the vector
     * @param other the vector to subtract
     * @return the new vector
     */
    operator fun minus(other: Vector4): Vector4 = Vector4(x - other.x, y - other.y, z - other.z, w - other.w)
    /**
     * Subtracts the x and y values of the vector
     * @param other the float to subtract
     * @return the new vector
     */
    operator fun minus(other: Float): Vector4 = Vector4(x - other, y - other, z - other, w - other)

    /**
     * multiply the x and y values of the vector
     * @param other the vector to multiply
     * @return the new vector
     */
    operator fun times(other: Float): Vector4 = Vector4(x * other, y * other, z * other, w * other)

    /**
     * dot product of 2 vectors
     * @param other the vector to dot
     * @return the dot product
     */
    infix fun dot(other: Vector4): Float = x * other.x + (y * other.y) + (z * other.z) + (w * other.w)

    /**
     * mix 2 vectors
     * @param other the vector to mix
     * @param t the mix value
     * @return the mixed vector
     */
    fun mix(other: Vector4, t: Float): Float = x * (1 - t) + (other.x * t) + (y * (1 - t)) + (other.y * t) + (z * (1 - t)) + (other.z * t) + (w * (1 - t)) + (other.w * t)


    //data methods
    /**
     * the length of the vector
     */
    val length: Float
        get() = sqrt((x * x + (y * y) + (z * z) + (w * w)))
}