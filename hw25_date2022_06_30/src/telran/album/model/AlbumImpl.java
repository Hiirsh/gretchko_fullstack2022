package telran.album.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class AlbumImpl implements Album {
  private Photo[] photos;
  private int size = 0;

  public AlbumImpl(int capacity) {
    this.photos = new Photo[capacity];
  }

  @Override
  public boolean addPhoto(Photo photo) {
    if (size == 0) {
      photos[0] = photo;
      size++;
      return true;
    }
    int index = Arrays.binarySearch(photos, 0, this.size, photo);
    if (index >= 0) {
      return false;
    }
    index = -index - 1;
    Photo[] temp = new Photo[photos.length];
    System.arraycopy(this.photos, 0, temp, 0, size);
    temp[index] = photo;
    System.arraycopy(this.photos, index, temp, index + 1, size);
    size++;
    this.photos = temp;
    return true;
  }

  @Override
  public boolean removePhoto(int photoId, int albumId) {
    int i = getIndexPhotoFromAlbum(photoId, albumId);
    if (i == -1) {
      return false;
    }
    size--;
    Photo[] temp = new Photo[size];
    System.arraycopy(this.photos, 0, temp, 0, i);
    System.arraycopy(this.photos, i + 1, temp, i, size - i);
    this.photos = temp;
    return true;
  }

  @Override
  public boolean updatePhoto(int photoId, int albumId, String url) {
    int i = getIndexPhotoFromAlbum(photoId, albumId);
    if (i == -1) {
      return false;
    }
    photos[i].setUrl(url);
    return true;
  }

  public boolean updatePhoto(int photoId, int albumId, String url, String title) {
    int i = getIndexPhotoFromAlbum(photoId, albumId);
    if (i == -1) {
      return false;
    }
    photos[i].setUrl(url);
    photos[i].setTitle(title);

    return false;
  }

  @Override
  public Photo getPhotoFromAlbum(int photoId, int albumId) {
    int index = getIndexPhotoFromAlbum(photoId, albumId);
    if (index == -1) {
      return null;
    }
    return photos[index];
  }

  @Override
  public Photo[] getAllPhotoFromAlbum(int albumId) {
    if (size == 0) {
      return null;
    }
    int counter = 0;
    Photo[] temp = new Photo[size];
    for (int i = 0; i < size; i++) {
      if (photos[i].getAlbumId() == albumId) {
        temp[counter] = photos[i];
        counter++;
      }
    }
    Photo[] res = new Photo[counter];
    System.arraycopy(temp, 0, res, 0, counter);
    return res;
  }

  @Override
  public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
    // int beginIndex = Arrays.binarySearch(photos, dateFrom);
    // int endIndex = Arrays.binarySearch(photos, dateTo);
    // beginIndex = beginIndex >= 0 ? beginIndex : -beginIndex - 1;
    // endIndex = endIndex >= 0 ? endIndex : -endIndex - 1;
    // for (int i = beginIndex; i >= 0; i--) {
    // if (photos[i].getDate().isBefore(photos[beginIndex].getDate())) {
    // beginIndex = i;
    // break;
    // }
    // }
    // for (int i = endIndex; i < photos.length; i++) {
    // if (photos[i].getDate().isAfter(photos[beginIndex].getDate())) {
    // endIndex = i;
    // break;
    // }
    // }
    LocalDateTime dateFromTemp = LocalDateTime.of(dateFrom, LocalTime.of(0, 0));
    LocalDateTime dateToTemp = LocalDateTime.of(dateTo, LocalTime.of(23, 59));
    int beginIndex = 0;
    int endIndex = size;
    for (int i = 0; i < endIndex; i++) {
      if (photos[i].getDate().isAfter(dateFromTemp)) {
        beginIndex = i;
      }
    }
    for (int i = size - 1; i > beginIndex; i--) {
      if (photos[i].getDate().isBefore(dateToTemp)) {
        endIndex = i;
      }
    }
    Photo[] res = new Photo[endIndex - beginIndex];
    System.arraycopy(photos, beginIndex, res, 0, endIndex - beginIndex);
    return res;
  }

  @Override
  public int size() {
    return this.size;
  }

  private int getIndexPhotoFromAlbum(int photoId, int albumId) {
    if (size == 0) {
      return -1;
    }
    for (int i = 0; i < size; i++) {
      if (photos[i].getAlbumId() == albumId && photos[i].getPhotoId() == photoId) {
        return i;
      }
    }
    return -1;
  }

}
