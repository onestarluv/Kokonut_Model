/*
 * This source file is part of BetterModel.
 * Copyright (c) 2024 toxicity188
 * Licensed under the MIT License.
 * See LICENSE.md file for full license text.
 */

package kr.toxicity.model.api.nms;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * Enumerates supported Minecraft server versions and their associated metadata.
 * <p>
 * This enum maps internal version identifiers to Minecraft versions and resource pack formats.
 * </p>
 *
 * @since 1.15.2
 */
@RequiredArgsConstructor
@Getter
public enum NMSVersion {
    /**
     * Minecraft 26.3.x
     * @since 3.5.0
     */
    V26_R3(97);
    /**
     * The resource pack format version (pack.mcmeta).
     */
    private final int metaVersion;

    /**
     * Returns the oldest supported version.
     *
     * @return the first version enum
     * @since 1.15.2
     */
    public static @NotNull NMSVersion first() {
        return V26_R3;
    }

    /**
     * Returns the latest supported version.
     *
     * @return the last version enum
     * @since 1.15.2
     */
    public static @NotNull NMSVersion latest() {
        return V26_R3;
    }
}
