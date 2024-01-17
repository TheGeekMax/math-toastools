package dev.toastcie.mathtoastools.vector.intvector

import kotlin.math.sqrt

data class Vector3Int(val x: Int, val y: Int, val z: Int) {
    constructor(xy: Vector2Int, z: Int) : this(xy.x,xy.y,z)

    //editing methods

    //specials vectors
    val xy: Vector2Int
        get() = Vector2Int(x, y)

    val xz: Vector2Int
        get() = Vector2Int(x, z)

    val yz: Vector2Int
        get() = Vector2Int(y, z)

    //calculations methods
    operator fun plus(other: Vector3Int): Vector3Int = Vector3Int(x + other.x, y + other.y, z + other.z)
    operator fun plus(other: Int): Vector3Int = Vector3Int(x + other, y + other, z + other)


    operator fun minus(other: Vector3Int): Vector3Int = Vector3Int(x - other.x, y - other.y, z - other.z)
    operator fun minus(other: Int): Vector3Int = Vector3Int(x - other, y - other, z - other)

    operator fun times(other: Vector3Int): Vector3Int = Vector3Int(
        y * other.z - z * other.y,
        z * other.x - x * other.z,
        x * other.y - y * other.x
    )
    operator fun times (scalar: Int): Vector3Int = Vector3Int(x * scalar, y * scalar, z * scalar)

    infix fun dot(other: Vector3Int): Int = x * other.x + (y * other.y) + (z * other.z)

}