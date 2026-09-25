/*
 * Copyright (C) 2026 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sonyericsson.provider;

import android.compat.annotation.UnsupportedAppUsage;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * The {@link MediaStore} columns and URIs the pre-installed Sony camera applications expect.
 *
 * @hide
 */
public final class SemcMediaStore {

    @UnsupportedAppUsage
    public static final String AUTHORITY = "media";

    private static final String CONTENT_AUTHORITY_SLASH = "content://" + AUTHORITY + "/";

    private static final String TABLE_EXT_FILE = "/extended_file";

    private SemcMediaStore() {
    }

    /**
     * Files, with the Sony specific columns.
     *
     * @hide
     */
    public static final class ExtendedFiles {

        private ExtendedFiles() {
        }

        /**
         * Get the content URI for the extended file table on the given volume.
         *
         * @hide
         */
        @UnsupportedAppUsage
        public static Uri getContentUri(String volumeName) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName + TABLE_EXT_FILE);
        }

        /**
         * Get the content URI for a single row of the extended file table.
         *
         * @hide
         */
        @UnsupportedAppUsage
        public static Uri getContentUri(String volumeName, long rowId) {
            return Uri.parse(CONTENT_AUTHORITY_SLASH + volumeName + TABLE_EXT_FILE + "/" + rowId);
        }

        /**
         * Columns of the extended file table.
         *
         * @hide
         */
        public interface ExtendedFileColumns extends MediaStore.MediaColumns {
            String SOMC_FILE_TYPE = "somctype";
            String SOMC_FILE_HASH = "somchash";
            String SOMC_FOLDER_CATEGORY = "somccategory";
            String FILE_LINK_PATH = "filelinkpath";
            String TITLE_YOMI = "title_yomi";
            String USER_RATING = "userrating";
            String AUDIO_BITRATE = "audiobitrate";
            String AUDIO_NUMBER_OF_CHANNELS = "audionumchannels";
            String AUDIO_SAMPLE_DEPTH = "audiosampledepth";
            String AUDIO_SAMPLE_RATE = "audiosamplerate";
            String AUDIO_WAVE_CODEC = "audiowavecodec";
            String VIDEO_BITRATE = "videobitrate";
            String VIDEO_ENCODING_PROFILE = "videoencodingprofile";
            String VIDEO_FOURCC_CODEC = "videofourcccodec";
            String VIDEO_FRAMES_PER_THOUSAND_SECONDS = "videoframesperthousandseconds";
            String VIDEO_SCAN_TYPE = "videoscantype";

            int SOMC_FILE_TYPE_NONE = 0x0;
            int SOMC_FILE_TYPE_BURST_COVER = 0x2;
            int SOMC_FILE_TYPE_TIMESHIFT_VIDEO_120F = 0xb;
            int SOMC_FILE_TYPE_TIMESHIFT_VIDEO = 0xc;
            int SOMC_FILE_TYPE_HIGHLIGHT_VIDEO = 0xe;
            int SOMC_FILE_TYPE_BURST_IMAGE = 0x81;
        }
    }
}
