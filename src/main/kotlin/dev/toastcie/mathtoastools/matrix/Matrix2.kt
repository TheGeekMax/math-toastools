package main.kotlin.dev.toastcie.mathtoastools.matrix

import dev.toastcie.mathtoastools.vector.Vector2
import kotlin.math.cos
import kotlin.math.sin

/**
 * A 2x2 matrix
 * @property a the a value of the matrix
 * @property b the b value of the matrix
 * @property c the c value of the matrix
 * @property d the d value of the matrix
 */
data class Matrix2(var a: Float, var b: Float, var c: Float, var d: Float){

    /**
     * add the values of 2 matrix
     * @param other the matrix to add
     * @return the new matrix
     */
    operator fun plus(other: Matrix2): Matrix2 = Matrix2(a + other.a, b + other.b, c + other.c, d + other.d)
    /**
     * subtract the values of 2 matrix
     * @param other the matrix to subtract
     * @return the new matrix
     */
    operator fun minus(other: Matrix2): Matrix2 = Matrix2(a - other.a, b - other.b, c - other.c, d - other.d)
    /**
     * multiply the values of 2 matrix
     * @param other the matrix to multiply
     * @return the new matrix
     */
    operator fun times(other: Matrix2): Matrix2 = Matrix2(a * other.a + b * other.c, a * other.b + b * other.d, c * other.a + d * other.c, c * other.b + d * other.d)
    /**
     * multiply the values of 2 matrix
     * @param other the float to multiply
     * @return the new matrix
     */
    operator fun times(other: Float): Matrix2 = Matrix2(a * other, b * other, c * other, d * other)
    /**
     * divide the values of 2 matrix
     * @param other the matrix to divide
     * @return the new matrix
     */
    operator fun div(other: Float): Matrix2 = Matrix2(a / other, b / other, c / other, d / other)
    /**
     * transpose the matrix
     * @return the new matrix
     */
    fun transpose(): Matrix2 = Matrix2(a, c, b, d)
    /**
     * @return the determinant of the matrix
     */
    fun determinant(): Float = a * d - b * c
    /**
     * @return the inverse of the matrix
     */
    fun inverse(): Matrix2 = Matrix2(d, -b, -c, a) / determinant()
    /**
     * @return the float array of the matrix
     */
    fun toFloatArray(): FloatArray = floatArrayOf(a, b, c, d)
    /**
     * apply a vector to the matrix
     * @param Vec the vector to apply
     * @return the new vector
     */
    fun apply(Vec: Vector2): Vector2 = Vector2(a * Vec.x + b * Vec.y, c * Vec.x + d * Vec.y)

    companion object {
        /**
         * @return the identity matrix
         */
        fun identity(): Matrix2 = Matrix2(1f, 0f, 0f, 1f)
        /**
         * @param angle the angle of the rotation
         * @return the rotation matrix
         */
        fun rotation(angle: Float): Matrix2 = Matrix2(cos(angle.toDouble()).toFloat(), -sin(angle.toDouble()).toFloat(), sin(angle.toDouble()).toFloat(), cos(angle.toDouble()).toFloat())
        /**
         * @param x the x value of the x scale
         * @param y the y value of the y scale
         * @return the associated scale matrix
         */
        fun scale(x: Float, y: Float): Matrix2 = Matrix2(x, 0f, 0f, y)
        /**
         * @param x the x value of the scale
         * @return the associated scale matrix
         */
        fun scale(x: Float): Matrix2 = Matrix2(x, 0f, 0f, x)
        /**
         * @param x the x value of the x shear
         * @param y the y value of the y shear
         * @return the associated shear matrix
         */
        fun shear(x: Float, y: Float): Matrix2 =  Matrix2(1f, x, y, 1f)
        /**
         * @param x the x value of the shear
         * @return the associated shear matrix
         */
        fun shear(x: Float): Matrix2 = Matrix2(1f,x,x,1f)
    }
}