package main.kotlin.dev.toastcie.mathtoastools.matrix

import dev.toastcie.mathtoastools.vector.Vector3
import kotlin.math.cos
import kotlin.math.sin

data class Matrix3(var a:Float, var b:Float, var c:Float, var d:Float, var e:Float, var f:Float, var g:Float, var h:Float, var i:Float){
    operator fun plus(other: Matrix3): Matrix3 = Matrix3(a + other.a, b + other.b, c + other.c, d + other.d, e + other.e, f + other.f, g + other.g, h + other.h, i + other.i)
    operator fun minus(other: Matrix3): Matrix3 = Matrix3(a - other.a, b - other.b, c - other.c, d - other.d, e - other.e, f - other.f, g - other.g, h - other.h, i - other.i)
    operator fun times(other: Matrix3): Matrix3 = Matrix3(a * other.a + b * other.d + c * other.g, a * other.b + b * other.e + c * other.h, a * other.c + b * other.f + c * other.i, d * other.a + e * other.d + f * other.g, d * other.b + e * other.e + f * other.h, d * other.c + e * other.f + f * other.i, g * other.a + h * other.d + i * other.g, g * other.b + h * other.e + i * other.h, g * other.c + h * other.f + i * other.i)
    operator fun times(other: Float): Matrix3 = Matrix3(a * other, b * other, c * other, d * other, e * other, f * other, g * other, h * other, i * other)
    operator fun div(other: Float): Matrix3 = Matrix3(a / other, b / other, c / other, d / other, e / other, f / other, g / other, h / other, i / other)
    fun transpose(): Matrix3 = Matrix3(a, d, g, b, e, h, c, f, i)
    fun determinant(): Float = a * e * i + b * f * g + c * d * h - c * e * g - b * d * i - a * f * h
    fun inverse(): Matrix3 = Matrix3(e * i - f * h, c * h - b * i, b * f - c * e, f * g - d * i, a * i - c * g, c * d - a * f, d * h - e * g, b * g - a * h, a * e - b * d) / determinant()
    fun toFloatArray(): FloatArray = floatArrayOf(a, b, c, d, e, f, g, h, i)
    fun apply(Vec: Vector3): Vector3 = Vector3(a * Vec.x + b * Vec.y + c * Vec.z, d * Vec.x + e * Vec.y + f * Vec.z, g * Vec.x + h * Vec.y + i * Vec.z)

    companion object {
        fun identity(): Matrix3 = Matrix3(1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f)
        fun rotationX(angle: Float): Matrix3 = Matrix3(1f, 0f, 0f, 0f, cos(angle.toDouble()).toFloat(), -sin(angle.toDouble()).toFloat(), 0f, sin(angle.toDouble()).toFloat(), cos(angle.toDouble()).toFloat())
        fun rotationY(angle: Float): Matrix3 = Matrix3(cos(angle.toDouble()).toFloat(), 0f, sin(angle.toDouble()).toFloat(), 0f, 1f, 0f, -sin(angle.toDouble()).toFloat(), 0f, cos(angle.toDouble()).toFloat())
        fun rotationZ(angle: Float): Matrix3 = Matrix3(cos(angle.toDouble()).toFloat(), -sin(angle.toDouble()).toFloat(), 0f, sin(angle.toDouble()).toFloat(), cos(angle.toDouble()).toFloat(), 0f, 0f, 0f, 1f)
        fun scale(x: Float, y: Float, z: Float): Matrix3 = Matrix3(x, 0f, 0f, 0f, y, 0f, 0f, 0f, z)
        fun scale(x: Float, y: Float): Matrix3 = Matrix3(x, 0f, 0f, 0f, y, 0f, 0f, 0f, 1f)
        fun scale(x: Float): Matrix3 = Matrix3(x, 0f, 0f, 0f, x, 0f, 0f, 0f, 1f)
        fun shear(x: Float, y: Float): Matrix3 = Matrix3(1f, x, 0f, y, 1f, 0f, 0f, 0f, 1f)
        fun shear(x: Float): Matrix3 = Matrix3(1f, x, 0f, x, 1f, 0f, 0f, 0f, 1f)
    }
}