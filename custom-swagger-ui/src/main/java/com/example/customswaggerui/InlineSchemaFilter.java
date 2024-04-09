package com.example.customswaggerui;

/*
public class InlineSchemaFilter implements SchemaFilter {

    @Override
    public void apply(AnnotatedType type, Schema schema) {
        // Check if the type is a complex type (like Map)
        if (type.getType() instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type.getType();

            // Check if the raw type is Map
            if (parameterizedType.getRawType() == Map.class) {
                // Get the type of the map values
                Type valueType = parameterizedType.getActualTypeArguments()[1];

                // Generate a schema for the map values
                Schema valueSchema = ModelConverters.getInstance()
                                                    .readAllAsResolvedSchema(new AnnotatedType(valueType)).schema;

                // Set the value schema as the additional properties of the map schema
                schema.additionalProperties(valueSchema);
            }
        }
    }
}*/