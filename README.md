# 📱 Appium Mobile Automation — Zero → First Automation

---

> 💡 এই ডকুমেন্টেশনটি আপনাকে **শূন্য থেকে শুরু করে** একটি সম্পূর্ণ মোবাইল অটোমেশন প্রোজেক্ট তৈরি করতে সাহায্য করবে ।
> 

### 🤖 What is Appium / Appium কী?

Appium হলো একটি open-source, cross-platform mobile automation framework। এটি দিয়ে Android এবং iOS — উভয় platform-এর native, hybrid এবং mobile web application automate করা যায়।

**Architecture:**

```
[Test Script (Java)] → HTTP → [Appium Server (Node.js)] → [UiAutomator2] → [Android Device]
```

**Why Appium?**

- ✅ Open Source — সম্পূর্ণ বিনামূল্যে
- ✅ Cross Platform — একই code দিয়ে Android ও iOS Test
- ✅ No App Modification — source code পরিবর্তন লাগে না
- ✅ Multiple Languages — Python, Java, JavaScript সব চলে

---

### 📋 System Requirements

| Tool | Version | Notes |
| --- | --- | --- |
| Java JDK | Latest | Adoptium Temurin recommended |
| Node.js | Latest | npm 8+ required |
| VS Code | Latest |  |
| Android Studio | Latest | For SDK + Emulator |
| Appium | Latest | Install via npm |
| RAM | 16 GB | 8 GB minimum |

---

### ✅ Step 1 — Java JDK Installation

**Download:** [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)

**Install:** Run installer → check **"Set JAVA_HOME variable"**

**Verify:**

```bash
java -version
```

**Set Environment Variable:**

`JAVA_HOME = C:\Program Files\Java\jdk-17`

📸 **Screenshot:** 

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image.png)

⚠️ **Problem I Faced:** `'java' is not recognized`**Solution:**  Manually JAVA_HOME set করুন

---

### ✅ Step 2 — Node.js Installation

**Appium server runs on Node.js - essential component.**

**Download:** [https://nodejs.org](https://nodejs.org) 

**Verify:**

```bash
node --version   
npm --version    
```

📸 **Screenshot:** 

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%201.png)

---

### ✅ Step 3 — Android Studio & SDK Setup

**Download:** https://developer.android.com/studio

**Install:** Setup Type → **Standard** → let SDK download (~3-5 GB)

**🔹 Set Environment Variables**

Start → search "Environment Variables" → "Edit the system environment variables"

System variables → **New**:
`JAVA_HOME` = `C:\Users\hp\AppData\Local\Android\Sdk`

📸 **Screenshot:** 

![Screenshot 2026-04-18 131509.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/Screenshot_2026-04-18_131509.png)

**🔹 Set** Path system variables

**Path** → Edit → New → add:

`%ANDROID_HOME%\emulator
%ANDROID_HOME%\tools
%ANDROID_HOME%\platform-tools
%ANDROID_HOME%\tools\bin`

📸 **Screenshot:** 

![Screenshot 2026-04-18 131533.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/Screenshot_2026-04-18_131533.png)

## Android Studio SDK Manager Setup:

- ✅ Android 16.0(Baklava) (API 36.0) — SDK Platforms tab
- ✅ Android SDK Build-Tools — SDK Tools tab
- ✅ Android Emulator — SDK Tools tab
- ✅ Android SDK Platform-Tools — SDK Tools tab

📸 **Screenshot:** 

![Screenshot 2026-04-18 125547.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/Screenshot_2026-04-18_125547.png)

![Screenshot 2026-04-18 125628.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/Screenshot_2026-04-18_125628.png)

### ✅ Step 4 — Environment Variables

> সবচেয়ে গুরুত্বপূর্ণ step — সাবধানে করুন!
> 

**Windows:**

1. Start → search "Environment Variables" → "Edit the system environment variables"
2. System variables → **New**:
    - `JAVA_HOME` = `C:\Program Files\Eclipse Adoptium\jdk-17.0.9.9-hotspot`
    - `ANDROID_HOME` = `C:\Users\YourName\AppData\Local\Android\Sdk`
3. **Path** → Edit → New → add:
    - `%ANDROID_HOME%\platform-tools`
    - `%ANDROID_HOME%\emulator`
    - `%ANDROID_HOME%\tools`

**macOS/Linux** (`~/.zshrc`):

```bash
export JAVA_HOME=$(/usr/libexec/java_home)
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$ANDROID_HOME/platform-tools:$PATH
export PATH=$ANDROID_HOME/emulator:$PATH
source ~/.zshrc
```

**Verify:**

```bash
adb --version
emulator -version
```

📸 **Screenshot:** `adb version` output in fresh terminal

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%202.png)

⚠️ **Problem:** `adb not found`**Solution:** PATH-এ `platform-tools` নেই। Add করুন, terminal **বন্ধ করে নতুন খুলুন**।

---

### ✅ Step 5 — Appium Server Installation

```bash
npm install -g appium
appium --version
```

**Diagnose your setup:**

```bash
npm install -g @appium/doctor
appium-doctor --android
```

📸 **Screenshot:** 

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%203.png)

---

### ✅ Step 6 — UiAutomator2 Driver

> Appium 2.x-এ drivers আলাদাভাবে install করতে হয়।
> 

```bash
appium driver install uiautomator2
appium driver list --installed
```

📸 **Screenshot:** 

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%204.png)

⚠️ **Problem:** Network timeout during install
**Solution:** `appium driver install uiautomator2 --source npm`

---

### ✅ Step 8 — Android Emulator তৈরি

1. Android Studio → More Actions → **Virtual Device Manager**
2. Create Device (+) → **Pixel 8** → Next
3. System Image: **API 34, Google Play** → Download → Next
4. AVD Name: `Pixel_8_API_34` → Finish
5. ▶ Play button → emulator boots (2-5 min)
    - Play button → emulator boots (2-5 min)
    - Play button → emulator boots (2-5 min)

📸 **Screenshot:** 

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%205.png)

**Real Device চাইলে:**

1. Settings → About Phone → Build Number → 7 বার tap (Developer Options unlock)
2. Developer Options → **USB Debugging ON**
3. USB cable → PC-তে connect → "Allow" tap
4. `adb devices` → device দেখাবে

⚠️ **Problem:** Emulator crash/slow
**Solution:** Windows 11 → Control Panel → Windows Features → **Windows Hypervisor Platform** ✔

---

### ✅ Step 9 — Appium Inspector

**Download:** https://github.com/appium/appium-inspector/releases

**Start server first:**

```bash
appium
```

**Inspector Capabilities (JSON):**

```json
{
  "platformName": "Android",
  "appium:automationName": "UiAutomator2",
  "appium:deviceName": "emulator-5554",
  "appium:appPackage": "com.android.calculator2",
  "appium:appActivity": ".Calculator",
  "appium:noReset": true
}
```

📸 **Screenshot:**

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%206.png)

---

### ✅ Step 10 — First Appium Test Run

**🟢 6. Start Appium Server**

`appium`

📸 **Screenshot:**

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%207.png)

**⚠️ Server running থাকা অবস্থায় Terminal বন্ধ করবেন না!** 

**📲 7. Device Connection**

`adb devices`

📸 **Screenshot:**

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%208.png)

# 🧪 8. First Appium Execution

## ✅ Code

**`tests/BaseTest.java`:**

```python
package com.qa;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setup() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options();
        TestConfig config = new TestConfig();

        options.setPlatformName(config.getPlatformName());
        options.setDeviceName(config.getDeviceName());
        options.setUdid(config.getUdid());
        options.setAppPackage(config.getAppPackage());
        options.setAppActivity(config.getAppActivity());
        options.setAutomationName("UiAutomator2");
        options.setNewCommandTimeout(Duration.ofSeconds(60));

        driver = new AndroidDriver(
                new URL(config.getAppiumServerUrl()),
                options
        );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected boolean isElementDisplayed(By locator) {
        return !driver.findElements(locator).isEmpty() && driver.findElement(locator).isDisplayed();
    }
}
```

**`tests/FirstTest.java`:**

```python
package com.qa;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest {

    @Test
    public void openSettingsTest() {
        By settingsTitle = By.xpath("//*[@text='Settings']");
        Assert.assertTrue(isElementDisplayed(settingsTitle), "Settings screen did not open.");
    }
}
```

`TestConfig.java`

```java
package com.qa;

public class TestConfig {

    public String getPlatformName() {
        return getValue("platformName", "Android");
    }

    public String getDeviceName() {
        return getValue("deviceName", "Android Emulator");
    }

    public String getUdid() {
        return getValue("udid", "emulator-5554");
    }

    public String getAppiumServerUrl() {
        return getValue("appiumServerUrl", "http://127.0.0.1:4723");
    }

    public String getAppPackage() {
        return getValue("appPackage", "com.android.settings");
    }

    public String getAppActivity() {
        return getValue("appActivity", ".Settings");
    }

    private String getValue(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        return value;
    }
}
```

📸 **Screenshot:** `PASSED` 

![image.png](%F0%9F%93%B1%20Appium%20Mobile%20Automation%20%E2%80%94%20Zero%20%E2%86%92%20First%20Automati/image%209.png)

---

### 🔧 Troubleshooting Guide

| Error | Cause | Solution |
| --- | --- | --- |
| `adb not found` | PATH missing platform-tools | Add `%ANDROID_HOME%\platform-tools` to PATH, reopen terminal |
| `ConnectionRefusedError` | Appium server not running | Run `appium` in a separate terminal |
| `SessionNotCreatedException` | Emulator not connected | Check `adb devices` before running test |
| `Could not start a new session` | Wrong appPackage/appActivity | Used Appium Inspector to find correct values |
| `Appium Doctor Errors` | Missing environment variables | Correct ANDROID_HOME path |
| `no devices found` | Device Not Detected | `adb kill-server
adb start-server` |

## **📊 ফাইনাল চেকলিস্ট / Final Checklist**

অটোমেশন রেডি কিনা নিশ্চিত করতে নিচের টেবিলটি চেক করুন:

| **Task** | **Status** | **Command to Verify** |
| --- | --- | --- |
| Java JDK Installed | ✅  | `java -version` |
| Node.js Installed | ✅  | `node --version` |
| Android Studio + SDK | ✅  | `adb --version` |
| ANDROID_HOME Set | ✅  | `echo %ANDROID_HOME%` |
| Appium Installed | ✅  | `appium --version` |
| UiAutomator2 Driver | ✅  | `appium driver list --installed` |
| Emulator Running | ✅  | `adb devices` |
| Test Script Works | ✅  | `mvn test` |

### 🏆 Final Result

**যা যা শিখলাম:**

- ✅ Java JDK, Node.js, Android Studio scratch to install
- ✅ Environment variables correctly configure
- ✅ Appium  + UiAutomator2 driver setup
- ✅ Android Emulator create and configure
- ✅ Appium Inspector দিয়ে UI elements identify
- ✅ java automation script তৈরি

**Resources:**

- Appium Docs: https://appium.io/docs/en/latest/
- Appium Inspector: https://github.com/appium/appium-inspector/releases

*Made with ❤️ for learning automation - Questions? Feel free to reach out!*