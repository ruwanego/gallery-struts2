package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.model.Album;
import net.feminaexlux.gallery.struts2.model.Resource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ResourceServiceTest {
	private ResourceService resourceService;

	@Mock
	private Resource resource;
	@Mock
	private ResourceDAO resourceDAO;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		resourceService = new ResourceService();

		Whitebox.setInternalState(resourceService, "resourceDAO", resourceDAO);
	}

	@Test
	public void testSave_NewNotUpdated() throws Exception {
		when(resource.getId()).thenReturn(0);

		resourceService.save(resource);

		verify(resource, never()).setUpdated(any(Date.class));
	}

	@Test
	public void testSave_ExistingUpdated() throws Exception {
		when(resource.getId()).thenReturn(123);

		resourceService.save(resource);

		verify(resource).setUpdated(any(Date.class));
	}

	@Test
	public void testSave_LinkableSlugSet() throws Exception {
		Album album = mock(Album.class);

		when(album.getId()).thenReturn(123);
		when(album.getName()).thenReturn("album");

		resourceService.save(album);

		verify(album).setSlug("album");
		verify(album).setUpdated(any(Date.class));
	}
}
