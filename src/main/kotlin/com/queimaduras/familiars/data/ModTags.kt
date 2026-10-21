package com.queimaduras.familiars.data

import com.queimaduras.familiars.Familiars
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadOnlyProperty

object ModTags {
    abstract class TagGroup<T : Any>(private val registry: ResourceKey<out Registry<T>>) {
        protected fun tag(name: String, namespace: String = "c"): TagKey<T> =
            TagKey.create(registry, Identifier.fromNamespaceAndPath(namespace, name))

        protected fun modTag(name: String): TagKey<T> =
            tag(name, Familiars.MODID)

        protected fun modTag(): PropertyDelegateProvider<Any?, ReadOnlyProperty<Any?, TagKey<T>>> =
            PropertyDelegateProvider { _, property ->
                val key = modTag(property.name.lowercase())
                ReadOnlyProperty { _, _ -> key }
            }
    }

    object BLOCKS : TagGroup<Block>(Registries.BLOCK) {
        val STORAGE_BLOCKS_SALT = tag("storage_blocks/salt")
    }

    object ITEMS : TagGroup<Item>(Registries.ITEM) {
        val DUSTS_SALT = tag("dusts/salt")
        val STORAGE_BLOCKS_SALT = tag("storage_blocks/salt")

        val RITUAL_MATERIALS by modTag()
    }

    // object ENTITIES : TagGroup<EntityType<*>>(Registries.ENTITY_TYPE)
}
