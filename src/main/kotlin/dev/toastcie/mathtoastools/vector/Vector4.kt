package dev.toastcie.mathtoastools.vector

import kotlin.math.sqrt

data class Vector4(var x:Float, var y:Float, var z:Float, var w:Float) {
    constructor(xy: Vector2, z: Float, w: Float) : this(xy.x, xy.y, z, w)

    constructor(xyz: Vector3, w: Float) : this(xyz.x, xyz.y, xyz.z, w)

    constructor(xy: Vector2, zw: Vector2) : this(xy.x, xy.y, zw.x, zw.y)

    //editing methods
    val normalize: Vector4
        get(){
            val len = length
            return Vector4(x / len, y / len, z / len, w / len)
        }


    //specials vectors
    val xy: Vector2
        get() = Vector2(x, y)

    val xz: Vector2
        get() = Vector2(x, z)

    val xw: Vector2
        get() = Vector2(x, w)

    val yz: Vector2
        get() = Vector2(y, z)

    val yw: Vector2
        get() = Vector2(y, w)

    val zw: Vector2
        get() = Vector2(z, w)

    val xyz: Vector3
        get() = Vector3(x, y, z)

    val xyw: Vector3
        get() = Vector3(x, y, w)

    val xzw: Vector3
        get() = Vector3(x, z, w)

    val yzw: Vector3
        get() = Vector3(y, z, w)

    //calculations methods
    operator fun plus(other: Vector4): Vector4 = Vector4(x + other.x, y + other.y, z + other.z, w + other.w)
    operator fun plus(other: Float): Vector4 = Vector4(x + other, y + other, z + other, w + other)

    operator fun minus(other: Vector4): Vector4 = Vector4(x - other.x, y - other.y, z - other.z, w - other.w)
    operator fun minus(other: Float): Vector4 = Vector4(x - other, y - other, z - other, w - other)

    operator fun times(other: Float): Vector4 = Vector4(x * other, y * other, z * other, w * other)

    infix fun dot(other: Vector4): Float = x * other.x + (y * other.y) + (z * other.z) + (w * other.w)

    fun mix(other: Vector4, t: Float): Float = x * (1 - t) + (other.x * t) + (y * (1 - t)) + (other.y * t) + (z * (1 - t)) + (other.z * t) + (w * (1 - t)) + (other.w * t)


    //data methods
    val length: Float
        get() = sqrt((x * x + (y * y) + (z * z) + (w * w)))
}