# Pipeline (GitHub Actions)

This project uses a simple GitHub Actions workflow to run Maven builds on push and pull requests.

What the workflow does
- Runs on push and pull_request to `main` and `master`.
- Tests against JDK 11 and JDK 21 using a matrix.
- Caches Maven dependencies using `actions/setup-java` caching.
- Runs `mvn -B -V verify`.

Run the build locally
1. Make sure Java (11 or 21) and Maven are installed and on your PATH.
2. From the project root run:

```cmd
mvn -B -V verify
```

Notes
- If your project requires a different branch, update the `on` section in `.github/workflows/maven.yml`.
- The workflow uses the `temurin` distribution from `actions/setup-java@v4`.
