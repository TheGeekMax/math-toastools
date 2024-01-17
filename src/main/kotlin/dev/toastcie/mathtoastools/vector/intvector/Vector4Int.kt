package dev.toastcie.mathtoastools.vector.intvector

import kotlin.math.sqrt

data class Vector4Int(val x:Int, val y:Int, val z:Int, val w:Int) {
    constructor(xy: Vector2Int, z: Int, w: Int) : this(xy.x, xy.y, z, w)

    constructor(xyz: Vector3Int, w: Int) : this(xyz.x, xyz.y, xyz.z, w)

    constructor(xy: Vector2Int, zw: Vector2Int) : this(xy.x, xy.y, zw.x, zw.y)

    //specials vectors
    val xy: Vector2Int
        get() = Vector2Int(x, y)

    val xz: Vector2Int
        get() = Vector2Int(x, z)

    val xw: Vector2Int
        get() = Vector2Int(x, w)

    val yz: Vector2Int
        get() = Vector2Int(y, z)

    val yw: Vector2Int
        get() = Vector2Int(y, w)

    val zw: Vector2Int
        get() = Vector2Int(z, w)

    val xyz: Vector3Int
        get() = Vector3Int(x, y, z)

    val xyw: Vector3Int
        get() = Vector3Int(x, y, w)

    val xzw: Vector3Int
        get() = Vector3Int(x, z, w)

    val yzw: Vector3Int
        get() = Vector3Int(y, z, w)

    //calculations methods
    operator fun plus(other: Vector4Int): Vector4Int = Vector4Int(x + other.x, y + other.y, z + other.z, w + other.w)
    operator fun plus(other: Int): Vector4Int = Vector4Int(x + other, y + other, z + other, w + other)

    operator fun minus(other: Vector4Int): Vector4Int = Vector4Int(x - other.x, y - other.y, z - other.z, w - other.w)
    operator fun minus(other: Int): Vector4Int = Vector4Int(x - other, y - other, z - other, w - other)

    operator fun times(other: Int): Vector4Int = Vector4Int(x * other, y * other, z * other, w * other)

    infix fun dot(other: Vector4Int): Int = x * other.x + (y * other.y) + (z * other.z) + (w * other.w)
}