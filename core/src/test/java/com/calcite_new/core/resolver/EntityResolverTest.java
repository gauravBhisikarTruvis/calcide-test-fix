package com.calcite_new.core.resolver;

import com.calcite_new.core.model.EntityCatalog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

class EntityResolverTest {
    @Test
    void testEntityResolver() {
        EntityCatalog catalog = Mockito.mock(EntityCatalog.class);
        EntityResolver resolver = new EntityResolver(catalog);
        assertNotNull(resolver);
    }
}
