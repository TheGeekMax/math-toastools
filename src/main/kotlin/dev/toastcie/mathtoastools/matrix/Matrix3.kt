package main.kotlin.dev.toastcie.mathtoastools.matrix

import dev.toastcie.mathtoastools.vector.Vector3
import kotlin.math.cos
import kotlin.math.sin

/**
 * A 3x3 matrix
 * @property a the a value of the matrix
 * @property b the b value of the matrix
 * @property c the c value of the matrix
 * @property d the d value of the matrix
 * @property e the e value of the matrix
 * @property f the f value of the matrix
 * @property g the g value of the matrix
 * @property h the h value of the matrix
 * @property i the i value of the matrix
 */
data class Matrix3(var a:Float, var b:Float, var c:Float, var d:Float, var e:Float, var f:Float, var g:Float, var h:Float, var i:Float){
    /**
     * add the values of 2 matrix
     * @param other the matrix to add
     * @return the new matrix
     */
    operator fun plus(other: Matrix3): Matrix3 = Matrix3(a + other.a, b + other.b, c + other.c, d + other.d, e + other.e, f + other.f, g + other.g, h + other.h, i + other.i)
    /**
     * subtract the values of 2 matrix
     * @param other the matrix to subtract
     * @return the new matrix
     */
    operator fun minus(other: Matrix3): Matrix3 = Matrix3(a - other.a, b - other.b, c - other.c, d - other.d, e - other.e, f - other.f, g - other.g, h - other.h, i - other.i)
    /**
     * multiply the values of 2 matrix
     * @param other the matrix to multiply
     * @return the new matrix
     */
    operator fun times(other: Matrix3): Matrix3 = Matrix3(a * other.a + b * other.d + c * other.g, a * other.b + b * other.e + c * other.h, a * other.c + b * other.f + c * other.i, d * other.a + e * other.d + f * other.g, d * other.b + e * other.e + f * other.h, d * other.c + e * other.f + f * other.i, g * other.a + h * other.d + i * other.g, g * other.b + h * other.e + i * other.h, g * other.c + h * other.f + i * other.i)

    /**
     * multiply the values with a float
     * @param other the float to multiply
     * @return the new matrix
     */
    operator fun times(other: Float): Matrix3 = Matrix3(a * other, b * other, c * other, d * other, e * other, f * other, g * other, h * other, i * other)
    /**
     * divide the values with a float
     * @param other the matrix to divide
     * @return the new matrix
     */
    operator fun div(other: Float): Matrix3 = Matrix3(a / other, b / other, c / other, d / other, e / other, f / other, g / other, h / other, i / other)
    /**
     * transpose the matrix
     * @return the new matrix
     */
    fun transpose(): Matrix3 = Matrix3(a, d, g, b, e, h, c, f, i)
    /**
     * @return the determinant of the matrix
     */
    fun determinant(): Float = a * e * i + b * f * g + c * d * h - c * e * g - b * d * i - a * f * h
    /**
     * @return the inverse of the matrix
     */
    fun inverse(): Matrix3 = Matrix3(e * i - f * h, c * h - b * i, b * f - c * e, f * g - d * i, a * i - c * g, c * d - a * f, d * h - e * g, b * g - a * h, a * e - b * d) / determinant()
    /**
     * @return the float array of the matrix
     */
    fun toFloatArray(): FloatArray = floatArrayOf(a, b, c, d, e, f, g, h, i)
    /**
     * apply a vector to the matrix
     * @param Vec the vector to apply
     * @return the new vector
     */
    fun apply(Vec: Vector3): Vector3 = Vector3(a * Vec.x + b * Vec.y + c * Vec.z, d * Vec.x + e * Vec.y + f * Vec.z, g * Vec.x + h * Vec.y + i * Vec.z)

    companion object {
        /**
         * @return the identity matrix
         */
        fun identity(): Matrix3 = Matrix3(1f, 0f, 0f, 0f, 1f, 0f, 0f, 0f, 1f)
        /**
         * @param angle the angle of the rotation (for x axis)
         * @return the x rotation matrix
         */
        fun rotationX(angle: Float): Matrix3 = Matrix3(1f, 0f, 0f, 0f, cos(angle.toDouble()).toFloat(), -sin(angle.toDouble()).toFloat(), 0f, sin(angle.toDouble()).toFloat(), cos(angle.toDouble()).toFloat())
        /**
         * @param angle the angle of the rotation (for y axis)
         * @return the y rotation matrix
         */
        fun rotationY(angle: Float): Matrix3 = Matrix3(cos(angle.toDouble()).toFloat(), 0f, sin(angle.toDouble()).toFloat(), 0f, 1f, 0f, -sin(angle.toDouble()).toFloat(), 0f, cos(angle.toDouble()).toFloat())
        /**
         * @param angle the angle of the rotation (for z axis)
         * @return the z rotation matrix
         */
        fun rotationZ(angle: Float): Matrix3 = Matrix3(cos(angle.toDouble()).toFloat(), -sin(angle.toDouble()).toFloat(), 0f, sin(angle.toDouble()).toFloat(), cos(angle.toDouble()).toFloat(), 0f, 0f, 0f, 1f)
        /**
         * @param x the x value of the scale
         * @param y the y value of the scale
         * @param z the z value of the scale
         * @return the associated scale matrix
         */
        fun scale(x: Float, y: Float, z: Float): Matrix3 = Matrix3(x, 0f, 0f, 0f, y, 0f, 0f, 0f, z)
        /**
         * @param x the x value of the scale
         * @param y the y value of the scale
         * @return the associated scale matrix
         */
        fun scale(x: Float, y: Float): Matrix3 = Matrix3(x, 0f, 0f, 0f, y, 0f, 0f, 0f, 1f)
        /**
         * @param x the x value of the scale
         * @return the associated scale matrix
         */
        fun scale(x: Float): Matrix3 = Matrix3(x, 0f, 0f, 0f, x, 0f, 0f, 0f, 1f)
        /**
         * @param x the x value of the x shear
         * @param y the y value of the y shear
         * @return the associated shear matrix
         */
        fun shear(x: Float, y: Float): Matrix3 = Matrix3(1f, x, 0f, y, 1f, 0f, 0f, 0f, 1f)
        /**
         * @param x the x value of the shear
         * @return the associated shear matrix
         */
        fun shear(x: Float): Matrix3 = Matrix3(1f, x, 0f, x, 1f, 0f, 0f, 0f, 1f)
    }
}