package dev.toastcie.mathtoastools.vector;

public class Vector3 {
    //TODO auto edit xy yz xz variables when x y or z is edited
    public float x;
    public float y;
    public float z;

    public Vector3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3(Vector2 xy, float z) {
        this.x = xy.x;
        this.y = xy.y;
        this.z = z;
    }

    //editing methods

    public void normalize() {
        float length = this.length();
        this.x /= length;
        this.y /= length;
        this.z /= length;
    }

    //calculations methods

    public Vector3 add(Vector3 other) {
        return new Vector3(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector3 subtract(Vector3 other) {
        return new Vector3(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public Vector3 prod(float scalar) {
        return new Vector3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    public Vector3 cross(Vector3 other) {
        return new Vector3(this.y * other.z - this.z * other.y, this.z * other.x - this.x * other.z, this.x * other.y - this.y * other.x);
    }

    public float dot(Vector3 other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public float mix(Vector3 other, float t) {
        return this.x * (1 - t) + other.x * t + this.y * (1 - t) + other.y * t + this.z * (1 - t) + other.z * t;
    }

    //data methods

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }
}
