# N11 BootCamp - Yeni Ödeme Yöntemi Entegrasyonu (Ödev 1)

Bu proje, bir ödeme ekranı uygulamasının SOLID prensipleri doğrultusunda tasarlanmış Java implementasyonudur. Temel amaç, mevcut sisteme (Kredi Kartı) yeni bir ödeme yöntemini (PayPal, Apple Pay vb.) kodu bozmadan entegre edebilmektir.

## Mimari Yapı ve Tasarım Kararları

Proje geliştirilirken aşağıdaki SOLID prensipleri uygulanmıştır:

### 1. Single Responsibility Principle (SRP)
Her sınıfın tek bir sorumluluğu vardır:
- `PaymentUI`: Sadece kullanıcı arayüzü ve girdi yönetimi.
- `PaymentService`: Ödeme sürecinin iş mantığı.
- `AmountValidator`: Sadece tutar doğrulaması.
- `PaymentRegistry`: Ödeme yöntemlerinin merkezi yönetimi ve eşleştirilmesi.

### 2. Open/Closed Principle (OCP)
Sistem, yeni ödeme yöntemlerine açıktır ancak mevcut kodun değiştirilmesine kapalıdır. Yeni bir ödeme yöntemi eklemek için:
- `PaymentMethod` interface'inden yeni bir sınıf türetilir.
- `PaymentRegistry` sınıfına yeni bir kayıt eklenir.
  Mevcut `PaymentService` veya `PaymentUI` sınıflarında hiçbir değişiklik yapılması gerekmez.

### 3. Dependency Inversion Principle (DIP)
`PaymentService` ve `PaymentUI` somut sınıflara (örneğin doğrudan CreditCard sınıfına) bağımlı değildir. Bunun yerine `PaymentMethod` arayüzüne bağımlıdır.

### 4. Strategy Design Pattern
Çalışma zamanında (runtime) kullanıcının seçtiği ödeme yöntemine göre farklı stratejilerin (`CreditCard`, `PayPal`, döviz cinsi vb.) çalıştırılması sağlanmıştır.

## Paket Yapısı
- `payment`: Ödeme yöntemleri ve strateji arayüzü.
- `service`: İş mantığı.
- `ui`: Swing kütüphanesi ile hazırlanmış görsel arayüz.
- `validation`: Veri kontrol mekanizması.
- `exceptions`: Uygulamaya özgü hata tipleri.

## Kullanılan Teknolojiler
- **Java:** Dil temelinde OOP prensipleri.
- **Swing:** Masaüstü kullanıcı arayüzü.

## Geliştirme Alanları
- Hata takibi için loglama (Logging) entegrasyonu eklenebilir.
- Veritabanı bağlantısı yapılabilir.
- Birim testleri ile kod doğruluğu kontrol altına alınabilir.

## 👩🏻‍💻 Geliştirici

Elifnur Dönmez

---
*Bu proje N11 BootCamp kapsamında ödev olarak hazırlanmıştır.*