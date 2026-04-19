# N11 BootCamp - Yeni Ödeme Yöntemi Entegrasyonu (Ödev 1)

Bu proje, bir ödeme sistemi uygulamasının **SOLID** prensipleri ve **Spring Boot** mimarisi doğrultusunda tasarlanmış Java implementasyonudur. Temel amaç; yeni ödeme yöntemlerinin (Kredi Kartı, PayPal, Apple Pay vb.) sisteme hiçbir kod değişikliği veya manuel müdahale gerektirmeden dinamik olarak dahil edilmesini sağlamaktır.

## Mimari Yapı ve Tasarım Kararları

Proje geliştirilirken aşağıdaki yazılım prensipleri ve teknolojiler harmanlanmıştır:

### 1. SOLID Prensipleri Uygulaması
*   **Single Responsibility Principle (SRP):** Her sınıfın tek bir sorumluluğu vardır. UI sadece arayüzle, Service sadece iş mantığıyla, Registry ise yöntem yönetimiyle ilgilenir.
*   **Open/Closed Principle (OCP):** Sistem yeni yöntemlere açıktır. Yeni bir `PaymentMethod` eklendiğinde mevcut kod değişmez.
*   **Dependency Inversion Principle (DIP):** Üst seviye modüller (`Service`, `UI`), alt seviye somut sınıflara değil, arayüzlere (`PaymentMethod`, `PaymentRepository`) bağımlıdır.

### 2. Dinamik Kayıt Sistemi (Reflection & Spring IoC)
Projenin en güçlü yanı olan `PaymentRegistry` sınıfı iki temel mekanizmayı birleştirir:
*   **Java Reflection API:** Çalışma zamanında (runtime) ilgili paketteki sınıfları tarar ve Enum değerleriyle eşleşen sınıfları otomatik olarak keşfeder.
*   **Spring ApplicationContext:** Keşfedilen sınıflar manuel olarak `new` ile oluşturulmaz; Spring'in IoC konteynerinden (`getBean`) çekilir. Bu sayede ödeme sınıfları içinde Spring'in tüm özelliklerini (Dependency Injection vb.) kullanmak mümkün hale gelir.

### 3. Hibrit Arayüz Desteği
Uygulama artık sadece bir masaüstü uygulaması değil, aynı zamanda modern bir web servisidir:
*   **Swing UI:** Kullanıcı dostu masaüstü arayüzü.
*   **Spring Boot REST Controller:** Dış dünyadan JSON formatında ödeme istekleri alabilen API katmanı.

## Paket Yapısı
- `controller`: API uç noktaları (REST Endpoints).
- `payment`: Ödeme stratejileri, Enum yapıları ve **Reflection tabanlı Registry**.
- `service`: İş mantığı, loglama ve koordinasyon katmanı.
- `repository`: Veri saklama katmanı (DB ve Dosya tabanlı).
- `ui`: Swing kütüphanesi ile hazırlanmış görsel arayüz.
- `validation`: Tutar ve veri doğrulama mekanizması.
- `exceptions`: Uygulamaya özgü hata tipleri.

## Kullanılan Teknolojiler
- **Java 21:** Modern Java özellikleri ve OOP prensipleri.
- **Spring Boot 3.x:** Dependency Injection ve Web yetenekleri.
- **Java Reflection API:** Dinamik sınıf yükleme ve otomasyon.
- **Swing:** Masaüstü kullanıcı arayüzü.
- **Maven:** Bağımlılık ve proje yönetimi.

## 🚦 Çalıştırma ve Test
Uygulama başlatıldığında hem Swing arayüzü açılır hem de 8080 portu üzerinden API hizmete girer.

### API üzerinden test etmek için:
Tarayıcınızdan veya Postman üzerinden aşağıdaki URL'yi kullanabilirsiniz:
```http
GET http://localhost:8080/pay?type=CREDIT_CARD&amount=100&currency=TL