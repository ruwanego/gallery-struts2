package net.feminaexlux.gallery.struts2.service;

import net.feminaexlux.gallery.struts2.dao.ResourceDAO;
import net.feminaexlux.gallery.struts2.model.Resource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.util.reflection.Whitebox;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
	public void testSave() throws Exception {
		when(resource.getId()).thenReturn(123);

		resourceService.save(resource);

		verify(resource).setUpdated(any(Date.class));
	}
}
