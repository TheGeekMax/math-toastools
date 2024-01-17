package dev.toastcie.mathtoastools.vector

import kotlin.math.sqrt

data class Vector2(val x: Float, val y: Float) {
    //editing methods
    val normalized: Vector2
        get(){
            val len = length
            return Vector2(x / len, y / len)
        }

    //calculations methods
    operator fun plus(other: Vector2): Vector2 = Vector2(x + other.x, y + other.y)
    operator fun plus(other: Float): Vector2 = Vector2(x + other, y + other)

    operator fun minus(other: Vector2): Vector2 = Vector2(x - other.x, y - other.y)
    operator fun minus(other: Float): Vector2 = Vector2(x - other, y - other)

    operator fun times(other: Vector2): Vector2 = Vector2(x * other.y, y * other.x)
    operator fun times(other: Float): Vector2 = Vector2(x * other, y * other)

    infix fun dot(other: Vector2): Float = x * other.x + y * other.y
    fun mix(other: Vector2, t: Float): Float = x * (1 - t) + (other.x * t) + (y * (1 - t)) + (other.y * t)

    //data methods
    val length: Float
        get() = sqrt(x * x + y * y).toFloat()
}