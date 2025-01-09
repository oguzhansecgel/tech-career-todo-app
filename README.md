# TodoApp API Documentation

## Technologies Used:
- Java 17
- Spring Boot
- Spring Data Rest
- PostgreSQL

## API Endpoints:

### 1. Tüm Tamamlanmış (Done) Görevleri Listeleme
**GET** `/api/v1/todo/find/by/status/done/jobs`  
Bu endpoint, tamamlanmış görevlerin listesini döner.

### 2. Tüm Tamamlanmış (Completed) Görevleri Listeleme
**GET** `/api/v1/todo/find/by/status/completed/jobs`  
Bu endpoint, tamamlanmış görevlerin listesini döner.

### 3. Tüm İptal Edilmiş Görevleri Listeleme
**GET** `/api/v1/todo/find/by/status/cancelled/jobs`  
Bu endpoint, iptal edilmiş görevlerin listesini döner.

### 4. Tüm Bekleyen (Pending) Görevleri Listeleme
**GET** `/api/v1/todo/find/by/status/pending/jobs`  
Bu endpoint, bekleyen görevlerin listesini döner.

### 5. Tüm Başlamamış Görevleri Listeleme
**GET** `/api/v1/todo/find/by/status/notStarted/jobs`  
Bu endpoint, henüz başlamamış görevlerin listesini döner.

### 6. Tüm Görevleri Listeleme
**GET** `/api/v1/todo/list/all/todo`  
Bu endpoint, tüm görevlerin listesini döner.

### 7. ID ile Görev Getirme
**GET** `/api/v1/todo/get/by/{id}`  
Belirtilen ID'ye sahip görevi döner.

**Path Parameter:**
- `id`: Görevin ID'si

### 8. Başlama Zamanına Göre Görevleri Listeleme
**GET** `/api/v1/todo/by-started-time?startedTime={startedTime}`  
Başlama tarihine göre görevleri filtreler.

**Query Parameter:**
- `startedTime`: Başlama tarihi (YYYY-MM-DD)

### 9. Bitiş Zamanına Göre Görevleri Listeleme
**GET** `/api/v1/todo/by-finish-time?finishTime={finishTime}`  
Bitiş tarihine göre görevleri filtreler.

**Query Parameter:**
- `finishTime`: Bitiş tarihi (YYYY-MM-DD)

### 10. Görev Silme
**DELETE** `/api/v1/todo/delete/todo/{id}`  
Belirtilen ID'ye sahip görevi siler.

**Path Parameter:**
- `id`: Görevin ID'si

### 11. Yeni Görev Oluşturma
**POST** `/api/v1/todo/create/todo`  
Yeni bir görev oluşturur.

**Request Body:**
```json
{
  "taskName": "Yeni Görev",
  "status": "PENDING",
  "startedTime": "2023-02-01",
  "finishTime": "2023-02-05"
}
```

### 12. Görev Güncelleme
**PUT** `/api/v1/todo/update/todo/{id}`  
Belirtilen ID'ye sahip görevi günceller.

**Path Parameter:**
- `id`: Görevin ID'si

**Request Body:**
```json
{
  "taskName": "Güncellenmiş Görev",
  "status": "COMPLETED",
  "startedTime": "2023-02-01",
  "finishTime": "2023-02-06"
}


You can now copy and paste this section directly into your README file. Let me know if you need further assistance!
