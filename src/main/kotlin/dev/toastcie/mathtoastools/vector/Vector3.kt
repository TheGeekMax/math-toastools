package dev.toastcie.mathtoastools.vector

import kotlin.math.sqrt

data class Vector3(val x: Float, val y: Float, val z: Float) {
    constructor(xy: Vector2, z: Float) : this(xy.x,xy.y,z)

    //editing methods
    val normalize: Vector3
        get(){
            val len = length
            return Vector3(x / len, y / len, z / len)
        }

    //specials vectors
    val xy: Vector2
        get() = Vector2(x, y)

    val xz: Vector2
        get() = Vector2(x, z)

    val yz: Vector2
        get() = Vector2(y, z)

    //calculations methods
    operator fun plus(other: Vector3): Vector3 = Vector3(x + other.x, y + other.y, z + other.z)
    operator fun plus(other: Float): Vector3 = Vector3(x + other, y + other, z + other)


    operator fun minus(other: Vector3): Vector3 = Vector3(x - other.x, y - other.y, z - other.z)
    operator fun minus(other: Float): Vector3 = Vector3(x - other, y - other, z - other)

    operator fun times(other: Vector3): Vector3 = Vector3(
        y * other.z - z * other.y,
        z * other.x - x * other.z,
        x * other.y - y * other.x
    )
    operator fun times (scalar: Float): Vector3 = Vector3(x * scalar, y * scalar, z * scalar)
    
    infix fun dot(other: Vector3): Float = x * other.x + (y * other.y) + (z * other.z)

    fun mix(other: Vector3, t: Float): Float = x * (1 - t) + (other.x * t) + (y * (1 - t)) + (other.y * t) + (z * (1 - t)) + (other.z * t)

    //data methods
    val length: Float
            get() = sqrt((x * x + (y * y) + (z * z)))
}