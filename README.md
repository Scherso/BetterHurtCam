<h2 align="center">

"Better-Hurt-Cam"

</h2>

<h4 align="center">

A Mod which allows you to adjust Minecraft's hurt animation, `hurtCameraEffect` on a slider.

</h4>

## Installation Guide

1. **Install Minecraft 1.8.9**
2. **Install the [Forge Loader for 1.8.9][forge]**
3. **Install the [latest Better-Hurt-Cam version][releases]**
4. **Place the mod in your `minecraft/mods` directory**

<details>
  <summary>
    For those who would like to build themselves</summary>

## Build with [Gradle][gradle] using [Arch Loom][archloom]

  <a href="https://www.gradle.org">
      <img align="right" height="40"
           src="https://iconape.com/wp-content/files/vf/348927/png/gradle-logo.png">
  </a>

- Make sure [Java 17][jdk] is installed on your computer

1. Git clone the project: `git clone https://github.com/Scherso/ForgeTemplate/`
2. Run:

- Unix in Terminal:

Note: If you plan to only build once add the `—no-daemon` flag to the build.

  ```bash
  cd ForgeTemplate ; chmod 755 ./gradlew && ./gradlew --refresh-dependencies build
  ```

- Windows in Powershell:

  ```powershell
  cd ForgeTemplate ; .\gradlew.bat --refresh-dependencies build
  ```

3. Check the directory `ForgeTemplate/build/libs` or Windows; `ForgeTemplate\build\libs`

## For [IntelliJ][intelliJ]

  <a href="https://www.jetbrains.com/idea/">
      <img align="right" height="40"
           src="https://resources.jetbrains.com/storage/products/company/brand/logos/IntelliJ_IDEA_icon.svg">
  </a>

### IDE Setup

1. Open the project from `File > Open...` Select ForgeTemplate from it’s given file location.
2. Let the IDE collect dependencies and index the code. (this may take a couple seconds)
3. Go to `File > Project Structure... > SDKs` and make sure an SDK for Java 17 is installed and selected, if not
   download it [here][jdk]

### Build

Test if the environment is set up correctly setup by clicking the refresh button in IntelliJ’s Gradle tab, if it has
indexed properly with no errors do the following:

1. Go to `ForgeTemplate > Tasks > loom > genSources` in the Gradle tab and run `genSources`
2. To build the mod as a jar run `ForgeTemplate > Tasks > build > build`. Gradle will create a new directory
   called `build`.
3. Once this process is done, the .jar file will be located in `build/libs` You can see this in your file tree.

[gradle]: https://www.gradle.org

[archloom]: https://github.com/Sk1erLLC/architectury-loom

[intelliJ]: https://www.jetbrains.com/idea/

[jdk]: https://www.azul.com/downloads/?version=java-17-lts&package=jdk

</details>

## Credits

<a href="https://github.com/boomboompower">
  <img align="right" width="60"
       src="https://user-images.githubusercontent.com/90007553/163434382-5f0afaed-6f6c-4c4f-93f4-196fea2bb6aa.png"
  />
</a>


<h5 align="left">

> Credits to [boomboompower][boomboompower] for the original mod, which allows you to completely cancel the hurt effect.
>
> You can find the original mod [here][hurtanimationremover]

</h5>


[forge]: https://files.minecraftforge.net/net/minecraftforge/forge/index_1.8.9.html

[releases]: https://github.com/Scherso/BetterHurtCam/releases

[boomboompower]: https://github.com/boomboompower

[hurtanimationremover]: https://github.com/boomboompower/HurtAnimationRemover
