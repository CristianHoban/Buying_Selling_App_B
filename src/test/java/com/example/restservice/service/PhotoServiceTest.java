package com.example.restservice.service;

import com.example.restservice.data.PhotoContract;
import com.example.restservice.model.Photo;
import com.example.restservice.model.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the PhotoService class.
 */
public class PhotoServiceTest {

    @Mock
    private PhotoContract photoContract;

    private PhotoService photoService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        photoService = new PhotoService(photoContract);
    }

    /**
     * Test for creating a photo.
     * Verifies that the photo is saved correctly.
     */
    @Test
    public void createPhotoTest() {
        Photo photo = new Photo(1, new Product(), "Example");
        when(photoContract.save(photo)).thenReturn(photo);

        Photo createdPhoto = photoService.createPhoto(photo);
        verify(photoContract).save(photo);
        assertEquals(photo, createdPhoto);
    }

    /**
     * Test for retrieving a photo by its ID.
     * Verifies that the correct photo is returned when searching by ID.
     */
    @Test
    public void getPhotoByIdTest() {
        Photo expectedPhoto = new Photo(1, new Product(), "Example");
        Mockito.when(photoContract.findById(1L)).thenReturn(Optional.of(expectedPhoto));

        Optional<Photo> actualPhoto = photoService.getPhotoById(1L);

        Mockito.verify(photoContract).findById(1L);
        assertEquals(Optional.of(expectedPhoto), actualPhoto);
    }

    /**
     * Test for updating a photo.
     * Verifies that the photo is updated correctly when it exists.
     */
    @Test
    public void updatePhotoTest1() {
        Photo newPhoto = new Photo(1, new Product(), "Example");
        Mockito.when(photoContract.existsById(1L)).thenReturn(true);
        Mockito.when(photoContract.save(newPhoto)).thenReturn(newPhoto);

        Photo updatedPhoto = photoService.updatePhoto(1L, newPhoto);

        assertNotNull(updatedPhoto);
        assertEquals(1L, updatedPhoto.getId());
        Mockito.verify(photoContract).existsById(1L);
        Mockito.verify(photoContract).save(newPhoto);

        assertEquals(newPhoto, updatedPhoto);
    }

    /**
     * Test for updating a photo that doesn't exist.
     * Verifies that the update operation fails and no changes are made.
     */
    @Test
    public void updatePhotoTest2() {
        Long photoId = 2L;
        Photo newPhoto = new Photo(1, new Product(), "Example");
        Mockito.when(photoContract.existsById(photoId)).thenReturn(false);

        Photo updatedPhoto = photoService.updatePhoto(photoId, newPhoto);

        assertNull(updatedPhoto);
        Mockito.verify(photoContract).existsById(photoId);
        Mockito.verify(photoContract, Mockito.never()).save(Mockito.any(Photo.class));
    }

    /**
     * Test for deleting a photo.
     * Verifies that the photo is deleted by its ID.
     */
    @Test
    public void deletePhotoTest() {
        photoService.deletePhoto(1L);
        Mockito.verify(photoContract, times(1)).deleteById(1L);
    }
}
