package main.kotlin.dev.toastcie.mathtoastools.matrix

import dev.toastcie.mathtoastools.vector.Vector2
import kotlin.math.cos
import kotlin.math.sin

data class Matrix2(var a: Float, var b: Float, var c: Float, var d: Float){
    operator fun plus(other: Matrix2): Matrix2 = Matrix2(a + other.a, b + other.b, c + other.c, d + other.d)
    operator fun minus(other: Matrix2): Matrix2 = Matrix2(a - other.a, b - other.b, c - other.c, d - other.d)
    operator fun times(other: Matrix2): Matrix2 = Matrix2(a * other.a + b * other.c, a * other.b + b * other.d, c * other.a + d * other.c, c * other.b + d * other.d)
    operator fun times(other: Float): Matrix2 = Matrix2(a * other, b * other, c * other, d * other)
    operator fun div(other: Float): Matrix2 = Matrix2(a / other, b / other, c / other, d / other)
    fun transpose(): Matrix2 = Matrix2(a, c, b, d)
    fun determinant(): Float = a * d - b * c
    fun inverse(): Matrix2 = Matrix2(d, -b, -c, a) / determinant()
    fun toFloatArray(): FloatArray = floatArrayOf(a, b, c, d)
    fun apply(Vec: Vector2): Vector2 = Vector2(a * Vec.x + b * Vec.y, c * Vec.x + d * Vec.y)

    companion object {
        fun identity(): Matrix2 = Matrix2(1f, 0f, 0f, 1f)
        fun rotation(angle: Float): Matrix2 = Matrix2(cos(angle.toDouble()).toFloat(), -sin(angle.toDouble()).toFloat(), sin(angle.toDouble()).toFloat(), cos(angle.toDouble()).toFloat())
        fun scale(x: Float, y: Float): Matrix2 = Matrix2(x, 0f, 0f, y)
        fun scale(x: Float): Matrix2 = Matrix2(x, 0f, 0f, x)
        fun shear(x: Float, y: Float): Matrix2 =  Matrix2(1f, x, y, 1f)
        fun shear(x: Float): Matrix2 = Matrix2(1f,x,x,1f)
    }
}