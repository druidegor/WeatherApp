# WeatherApp

![Android](https://img.shields.io/badge/Platform-Android-green)
![Kotlin](https://img.shields.io/badge/Language-Kotlin-blue)
![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose-brightgreen)
![Architecture](https://img.shields.io/badge/Architecture-MVVM%20%2B%20Clean-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

Приложение для просмотра текущей погоды и прогноза по геолокации или выбранному городу.
Разработано на Kotlin с использованием современных Android-подходов (Clean Architecture, MVVM).

---

## Функциональность

* Определение текущего местоположения через GPS
* Поиск города с динамическими подсказками при вводе
* Отображение текущей температуры, ветра и погодных условий
* Просмотр прогноза погоды
* Сохранение выбранного города локально

---

## Технологии

* Kotlin
* Jetpack Compose
* MVVM
* Clean Architecture
* Coroutines + Flow
* Room (локальное хранение)
* Retrofit (работа с API)
* Location Services (GPS)

---

## Скриншоты

(добавь сюда изображения из приложения)

```
![Main Screen](screenshots/main.png)
![Search City](screenshots/search.png)
![Weather Details](screenshots/details.png)
```

---

## Архитектура

Проект построен по принципам Clean Architecture:

* Presentation — Compose UI + ViewModel
* Domain — бизнес-логика, use cases
* Data — API, база данных, репозитории

---

## API

Приложение использует погодный API для получения данных о погоде.
(укажи конкретный сервис, например: OpenWeatherMap)

---

## Запуск проекта

1. Клонировать репозиторий:

```
git clone https://github.com/yourusername/weatherapp.git
```

2. Открыть в Android Studio
3. Добавить API-ключ в `local.properties`:

```
WEATHER_API_KEY=your_key_here
```

4. Запустить проект

---

## Особенности реализации

* Получение координат через FusedLocationProviderClient
* Динамический поиск городов (запрос при изменении текста)
* Обработка JSON-ответов с погодными данными
* Реактивное обновление UI через StateFlow

---

## Автор

Разработано в рамках обучения и практики Android-разработки.
Другие проекты можно посмотреть в профиле GitHub.
