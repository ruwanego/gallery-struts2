package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.AlbumDAO;
import net.feminaexlux.gallery.struts2.model.Album;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class AlbumServiceTest {
	private AlbumService albumService;

	@Mock
	private Album album;
	@Mock
	private AlbumDAO albumDAO;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		albumService = new AlbumService();

		Whitebox.setInternalState(albumService, "albumDAO", albumDAO);
	}

	@Test
	public void testSave_NewNotUpdated() throws Exception {
		when(album.getId()).thenReturn(0);
		when(album.getName()).thenReturn("name");

		albumService.save(album);

		verify(album, never()).setUpdated(any(Date.class));
	}

	@Test
	public void testSave_ExistingUpdated() throws Exception {
		when(album.getId()).thenReturn(123);
		when(album.getName()).thenReturn("name");

		albumService.save(album);

		verify(album).setUpdated(any(Date.class));
	}

	@Test
	public void testSave_LinkableSlugSet() throws Exception {
		Album album = mock(Album.class);

		when(album.getId()).thenReturn(123);
		when(album.getName()).thenReturn("album");

		albumService.save(album);

		verify(album).setSlug("album");
		verify(album).setUpdated(any(Date.class));
	}
}
