package dev.toastcie.mathtoastools.vector.intvector

import kotlin.math.sqrt

data class Vector2Int(val x: Int, val y: Int) {

    //calculations methods
    operator fun plus(other: Vector2Int): Vector2Int = Vector2Int(x + other.x, y + other.y)
    operator fun plus(other: Int): Vector2Int = Vector2Int(x + other, y + other)

    operator fun minus(other: Vector2Int): Vector2Int = Vector2Int(x - other.x, y - other.y)
    operator fun minus(other: Int): Vector2Int = Vector2Int(x - other, y - other)

    operator fun times(other: Vector2Int): Vector2Int = Vector2Int(x * other.y, y * other.x)
    operator fun times(other: Int): Vector2Int = Vector2Int(x * other, y * other)

    infix fun dot(other: Vector2Int): Int = x * other.x + y * other.y

    //data methods
}