package com.rabbit.first.domain.appstore;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Mr.Rabbit on 2017/6/22.
 */
@Entity
@OptimisticLocking(type = OptimisticLockType.ALL)
@DynamicUpdate
@Table(name = "zl_app")
public class ZlAppDO {
    private int id;
    private String adsType;
    private Long bytes;
    private String changelog;
    private Timestamp createDatetime;
    private String description;
    private String developerEmail;
    private String developerIntro;
    private String developerName;
    private String developerWebsite;
    private Long downloadCount;
    private String downloadCountStr;
    private String downloadUrl;
    private Long installedCount;
    private String installedCountStr;
    private String language;
    private Integer likesRate;
    private Integer minSdkVersion;
    private Integer outputNo;
    private String packageName;
    private Timestamp publishDate;
    private Integer recommendDiv;
    private String tagline;
    private String title;
    private Integer versionCode;
    private String versionName;
    private Integer status;
    private Integer recommendOutputNo;
    private String searchTag;
    private Integer temp;
    private String filePath;
    private String zlAppcol;
    private String vendor;
    private Integer point;
    private String appId;
    private String realDownloadUrl;
    private String md5;
    private Integer gameId;
    private String packageId;
    private Timestamp updateDatetime;
    @Version
    private long version;


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ads_type", nullable = true, length = 32)
    public String getAdsType() {
        return adsType;
    }

    public void setAdsType(String adsType) {
        this.adsType = adsType;
    }

    @Basic
    @Column(name = "bytes", nullable = true)
    public Long getBytes() {
        return bytes;
    }

    public void setBytes(Long bytes) {
        this.bytes = bytes;
    }

    @Basic
    @Column(name = "changelog", nullable = true, length = -1)
    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    @Basic
    @Column(name = "create_datetime", nullable = true)
    public Timestamp getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Timestamp createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "developer_email", nullable = true, length = 64)
    public String getDeveloperEmail() {
        return developerEmail;
    }

    public void setDeveloperEmail(String developerEmail) {
        this.developerEmail = developerEmail;
    }

    @Basic
    @Column(name = "developer_intro", nullable = true, length = 255)
    public String getDeveloperIntro() {
        return developerIntro;
    }

    public void setDeveloperIntro(String developerIntro) {
        this.developerIntro = developerIntro;
    }

    @Basic
    @Column(name = "developer_name", nullable = true, length = 64)
    public String getDeveloperName() {
        return developerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    @Basic
    @Column(name = "developer_website", nullable = true, length = 64)
    public String getDeveloperWebsite() {
        return developerWebsite;
    }

    public void setDeveloperWebsite(String developerWebsite) {
        this.developerWebsite = developerWebsite;
    }

    @Basic
    @Column(name = "download_count", nullable = true)
    public Long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Long downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Basic
    @Column(name = "download_count_str", nullable = true, length = 64)
    public String getDownloadCountStr() {
        return downloadCountStr;
    }

    public void setDownloadCountStr(String downloadCountStr) {
        this.downloadCountStr = downloadCountStr;
    }

    @Basic
    @Column(name = "download_url", nullable = true, length = 255)
    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Basic
    @Column(name = "installed_count", nullable = true)
    public Long getInstalledCount() {
        return installedCount;
    }

    public void setInstalledCount(Long installedCount) {
        this.installedCount = installedCount;
    }

    @Basic
    @Column(name = "installed_count_str", nullable = true, length = 64)
    public String getInstalledCountStr() {
        return installedCountStr;
    }

    public void setInstalledCountStr(String installedCountStr) {
        this.installedCountStr = installedCountStr;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 255)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "likes_rate", nullable = true)
    public Integer getLikesRate() {
        return likesRate;
    }

    public void setLikesRate(Integer likesRate) {
        this.likesRate = likesRate;
    }

    @Basic
    @Column(name = "min_sdk_version", nullable = true)
    public Integer getMinSdkVersion() {
        return minSdkVersion;
    }

    public void setMinSdkVersion(Integer minSdkVersion) {
        this.minSdkVersion = minSdkVersion;
    }

    @Basic
    @Column(name = "output_no", nullable = true)
    public Integer getOutputNo() {
        return outputNo;
    }

    public void setOutputNo(Integer outputNo) {
        this.outputNo = outputNo;
    }

    @Basic
    @Column(name = "package_name", nullable = true, length = 255)
    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Basic
    @Column(name = "publish_date", nullable = true)
    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "recommend_div", nullable = true)
    public Integer getRecommendDiv() {
        return recommendDiv;
    }

    public void setRecommendDiv(Integer recommendDiv) {
        this.recommendDiv = recommendDiv;
    }

    @Basic
    @Column(name = "tagline", nullable = true, length = 255)
    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "version_code", nullable = true)
    public Integer getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(Integer versionCode) {
        this.versionCode = versionCode;
    }

    @Basic
    @Column(name = "version_name", nullable = true, length = 64)
    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "recommend_output_no", nullable = true)
    public Integer getRecommendOutputNo() {
        return recommendOutputNo;
    }

    public void setRecommendOutputNo(Integer recommendOutputNo) {
        this.recommendOutputNo = recommendOutputNo;
    }

    @Basic
    @Column(name = "search_tag", nullable = true, length = 255)
    public String getSearchTag() {
        return searchTag;
    }

    public void setSearchTag(String searchTag) {
        this.searchTag = searchTag;
    }

    @Basic
    @Column(name = "temp", nullable = true)
    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    @Basic
    @Column(name = "file_path", nullable = true, length = 255)
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Basic
    @Column(name = "zl_appcol", nullable = true, length = 45)
    public String getZlAppcol() {
        return zlAppcol;
    }

    public void setZlAppcol(String zlAppcol) {
        this.zlAppcol = zlAppcol;
    }

    @Basic
    @Column(name = "vendor", nullable = true, length = 255)
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Basic
    @Column(name = "point", nullable = true)
    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    @Basic
    @Column(name = "app_id", nullable = true, length = 255)
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "real_download_url", nullable = true, length = -1)
    public String getRealDownloadUrl() {
        return realDownloadUrl;
    }

    public void setRealDownloadUrl(String realDownloadUrl) {
        this.realDownloadUrl = realDownloadUrl;
    }

    @Basic
    @Column(name = "md5", nullable = true, length = 255)
    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Basic
    @Column(name = "game_id", nullable = true)
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @Basic
    @Column(name = "package_id", nullable = true, length = 255)
    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    @Basic
    @Column(name = "update_datetime", nullable = true)
    public Timestamp getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Timestamp updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZlAppDO zlAppDO = (ZlAppDO) o;

        if (id != zlAppDO.id) return false;
        if (adsType != null ? !adsType.equals(zlAppDO.adsType) : zlAppDO.adsType != null) return false;
        if (bytes != null ? !bytes.equals(zlAppDO.bytes) : zlAppDO.bytes != null) return false;
        if (changelog != null ? !changelog.equals(zlAppDO.changelog) : zlAppDO.changelog != null) return false;
        if (createDatetime != null ? !createDatetime.equals(zlAppDO.createDatetime) : zlAppDO.createDatetime != null)
            return false;
        if (description != null ? !description.equals(zlAppDO.description) : zlAppDO.description != null) return false;
        if (developerEmail != null ? !developerEmail.equals(zlAppDO.developerEmail) : zlAppDO.developerEmail != null)
            return false;
        if (developerIntro != null ? !developerIntro.equals(zlAppDO.developerIntro) : zlAppDO.developerIntro != null)
            return false;
        if (developerName != null ? !developerName.equals(zlAppDO.developerName) : zlAppDO.developerName != null)
            return false;
        if (developerWebsite != null ? !developerWebsite.equals(zlAppDO.developerWebsite) : zlAppDO.developerWebsite != null)
            return false;
        if (downloadCount != null ? !downloadCount.equals(zlAppDO.downloadCount) : zlAppDO.downloadCount != null)
            return false;
        if (downloadCountStr != null ? !downloadCountStr.equals(zlAppDO.downloadCountStr) : zlAppDO.downloadCountStr != null)
            return false;
        if (downloadUrl != null ? !downloadUrl.equals(zlAppDO.downloadUrl) : zlAppDO.downloadUrl != null) return false;
        if (installedCount != null ? !installedCount.equals(zlAppDO.installedCount) : zlAppDO.installedCount != null)
            return false;
        if (installedCountStr != null ? !installedCountStr.equals(zlAppDO.installedCountStr) : zlAppDO.installedCountStr != null)
            return false;
        if (language != null ? !language.equals(zlAppDO.language) : zlAppDO.language != null) return false;
        if (likesRate != null ? !likesRate.equals(zlAppDO.likesRate) : zlAppDO.likesRate != null) return false;
        if (minSdkVersion != null ? !minSdkVersion.equals(zlAppDO.minSdkVersion) : zlAppDO.minSdkVersion != null)
            return false;
        if (outputNo != null ? !outputNo.equals(zlAppDO.outputNo) : zlAppDO.outputNo != null) return false;
        if (packageName != null ? !packageName.equals(zlAppDO.packageName) : zlAppDO.packageName != null) return false;
        if (publishDate != null ? !publishDate.equals(zlAppDO.publishDate) : zlAppDO.publishDate != null) return false;
        if (recommendDiv != null ? !recommendDiv.equals(zlAppDO.recommendDiv) : zlAppDO.recommendDiv != null)
            return false;
        if (tagline != null ? !tagline.equals(zlAppDO.tagline) : zlAppDO.tagline != null) return false;
        if (title != null ? !title.equals(zlAppDO.title) : zlAppDO.title != null) return false;
        if (versionCode != null ? !versionCode.equals(zlAppDO.versionCode) : zlAppDO.versionCode != null) return false;
        if (versionName != null ? !versionName.equals(zlAppDO.versionName) : zlAppDO.versionName != null) return false;
        if (status != null ? !status.equals(zlAppDO.status) : zlAppDO.status != null) return false;
        if (recommendOutputNo != null ? !recommendOutputNo.equals(zlAppDO.recommendOutputNo) : zlAppDO.recommendOutputNo != null)
            return false;
        if (searchTag != null ? !searchTag.equals(zlAppDO.searchTag) : zlAppDO.searchTag != null) return false;
        if (temp != null ? !temp.equals(zlAppDO.temp) : zlAppDO.temp != null) return false;
        if (filePath != null ? !filePath.equals(zlAppDO.filePath) : zlAppDO.filePath != null) return false;
        if (zlAppcol != null ? !zlAppcol.equals(zlAppDO.zlAppcol) : zlAppDO.zlAppcol != null) return false;
        if (vendor != null ? !vendor.equals(zlAppDO.vendor) : zlAppDO.vendor != null) return false;
        if (point != null ? !point.equals(zlAppDO.point) : zlAppDO.point != null) return false;
        if (appId != null ? !appId.equals(zlAppDO.appId) : zlAppDO.appId != null) return false;
        if (realDownloadUrl != null ? !realDownloadUrl.equals(zlAppDO.realDownloadUrl) : zlAppDO.realDownloadUrl != null)
            return false;
        if (md5 != null ? !md5.equals(zlAppDO.md5) : zlAppDO.md5 != null) return false;
        if (gameId != null ? !gameId.equals(zlAppDO.gameId) : zlAppDO.gameId != null) return false;
        if (packageId != null ? !packageId.equals(zlAppDO.packageId) : zlAppDO.packageId != null) return false;
        if (updateDatetime != null ? !updateDatetime.equals(zlAppDO.updateDatetime) : zlAppDO.updateDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (adsType != null ? adsType.hashCode() : 0);
        result = 31 * result + (bytes != null ? bytes.hashCode() : 0);
        result = 31 * result + (changelog != null ? changelog.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (developerEmail != null ? developerEmail.hashCode() : 0);
        result = 31 * result + (developerIntro != null ? developerIntro.hashCode() : 0);
        result = 31 * result + (developerName != null ? developerName.hashCode() : 0);
        result = 31 * result + (developerWebsite != null ? developerWebsite.hashCode() : 0);
        result = 31 * result + (downloadCount != null ? downloadCount.hashCode() : 0);
        result = 31 * result + (downloadCountStr != null ? downloadCountStr.hashCode() : 0);
        result = 31 * result + (downloadUrl != null ? downloadUrl.hashCode() : 0);
        result = 31 * result + (installedCount != null ? installedCount.hashCode() : 0);
        result = 31 * result + (installedCountStr != null ? installedCountStr.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (likesRate != null ? likesRate.hashCode() : 0);
        result = 31 * result + (minSdkVersion != null ? minSdkVersion.hashCode() : 0);
        result = 31 * result + (outputNo != null ? outputNo.hashCode() : 0);
        result = 31 * result + (packageName != null ? packageName.hashCode() : 0);
        result = 31 * result + (publishDate != null ? publishDate.hashCode() : 0);
        result = 31 * result + (recommendDiv != null ? recommendDiv.hashCode() : 0);
        result = 31 * result + (tagline != null ? tagline.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (versionCode != null ? versionCode.hashCode() : 0);
        result = 31 * result + (versionName != null ? versionName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (recommendOutputNo != null ? recommendOutputNo.hashCode() : 0);
        result = 31 * result + (searchTag != null ? searchTag.hashCode() : 0);
        result = 31 * result + (temp != null ? temp.hashCode() : 0);
        result = 31 * result + (filePath != null ? filePath.hashCode() : 0);
        result = 31 * result + (zlAppcol != null ? zlAppcol.hashCode() : 0);
        result = 31 * result + (vendor != null ? vendor.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (realDownloadUrl != null ? realDownloadUrl.hashCode() : 0);
        result = 31 * result + (md5 != null ? md5.hashCode() : 0);
        result = 31 * result + (gameId != null ? gameId.hashCode() : 0);
        result = 31 * result + (packageId != null ? packageId.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        return result;
    }
}
