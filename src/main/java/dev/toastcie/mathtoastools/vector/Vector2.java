package dev.toastcie.mathtoastools.vector;

public class Vector2 {
    public float x;
    public float y;

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    //editing methods

    public void normalize() {
        float length = this.length();
        this.x /= length;
        this.y /= length;
    }

    //calculations methods

    public Vector2 add(Vector2 other) {
        return new Vector2(this.x + other.x, this.y + other.y);
    }

    public Vector2 subtract(Vector2 other) {
        return new Vector2(this.x - other.x, this.y - other.y);
    }

    public Vector2 prod(float scalar) {
        return new Vector2(this.x * scalar, this.y * scalar);
    }

    public Vector2 cross(Vector2 other) {
        return new Vector2(this.x * other.y, this.y * other.x);
    }

    public float dot(Vector2 other) {
        return this.x * other.x + this.y * other.y;
    }

    public float mix(Vector2 other, float t) {
        return this.x * (1 - t) + other.x * t + this.y * (1 - t) + other.y * t;
    }

    //data methods

    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }
}