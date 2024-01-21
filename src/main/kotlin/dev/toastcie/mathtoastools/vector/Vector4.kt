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
    var xy: Vector2
        get() = Vector2(x, y)
        set(value) {
            x = value.x
            y = value.y
        }

    /**
     * the x and z values of the vector
     */
    var xz: Vector2
        get() = Vector2(x, z)
        set(value) {
            x = value.x
            z = value.y
        }

    /**
     * the x and w values of the vector
     */
    var xw: Vector2
        get() = Vector2(x, w)
        set(value) {
            x = value.x
            w = value.y
        }

    /**
     * the y and z values of the vector
     */
    var yz: Vector2
        get() = Vector2(y, z)
        set(value) {
            y = value.x
            z = value.y
        }

    /**
     * the y and w values of the vector
     */
    var yw: Vector2
        get() = Vector2(y, w)
        set(value) {
            y = value.x
            w = value.y
        }

    /**
     * the z and w values of the vector
     */
    var zw: Vector2
        get() = Vector2(z, w)
        set(value) {
            z = value.x
            w = value.y
        }

    /**
     * the x, y and z values of the vector
     */
    var xyz: Vector3
        get() = Vector3(x, y, z)
        set(value) {
            x = value.x
            y = value.y
            z = value.z
        }

    /**
     * the x, y and w values of the vector
     */
    var xyw: Vector3
        get() = Vector3(x, y, w)
        set(value) {
            x = value.x
            y = value.y
            w = value.z
        }

    /**
     * the x, z and w values of the vector
     */
    var xzw: Vector3
        get() = Vector3(x, z, w)
        set(value) {
            x = value.x
            z = value.y
            w = value.z
        }

    /**
     * the y, z and w values of the vector
     */
    var yzw: Vector3
        get() = Vector3(y, z, w)
        set(value) {
            y = value.x
            z = value.y
            w = value.z
        }

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