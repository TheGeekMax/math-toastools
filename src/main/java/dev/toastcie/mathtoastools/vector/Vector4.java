package dev.toastcie.mathtoastools.vector;

public class Vector4 {
    //TODO auto edit xyz xyw xzw yzw (and xy xz xw yz yw zw) variables when x y z or w is edited
    public float x;
    public float y;
    public float z;
    public float w;

    public Vector4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;

    }

    public Vector4(Vector2 xy, float z, float w) {
        this.x = xy.x;
        this.y = xy.y;
        this.z = z;
        this.w = w;

    }

    public Vector4(Vector3 xyz, float w) {
        this.x = xyz.x;
        this.y = xyz.y;
        this.z = xyz.z;
        this.w = w;

    }

    public Vector4(Vector2 xy, Vector2 zw) {
        this.x = xy.x;
        this.y = xy.y;
        this.z = zw.x;
        this.w = zw.y;

    }

    //editing methods

    public void normalize() {
        float length = this.length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
        this.w /= length;
    }

    //calculations methods

    public Vector4 add(Vector4 other) {
        return new Vector4(this.x + other.x, this.y + other.y, this.z + other.z, this.w + other.w);
    }

    public Vector4 subtract(Vector4 other) {
        return new Vector4(this.x - other.x, this.y - other.y, this.z - other.z, this.w - other.w);
    }

    public Vector4 prod(float scalar) {
        return new Vector4(this.x * scalar, this.y * scalar, this.z * scalar, this.w * scalar);
    }

    public Vector4 cross(Vector4 other) {
        return new Vector4(this.y * other.z - this.z * other.y, this.z * other.x - this.x * other.z, this.x * other.y - this.y * other.x, 0);
    }

    public float dot(Vector4 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z + this.w * other.w;
    }

    public float mix(Vector4 other, float t) {
        return this.x * (1 - t) + other.x * t + this.y * (1 - t) + other.y * t + this.z * (1 - t) + other.z * t + this.w * (1 - t) + other.w * t;
    }

    //data methods

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z + this.w * this.w);
    }
}
