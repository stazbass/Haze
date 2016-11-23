package com.nkttk.core.clients;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.HttpMethod;
import com.amazonaws.regions.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.S3ResponseMetadata;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.services.s3.waiters.AmazonS3Waiters;
import com.nkttk.core.engine.AWSEngine;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class HazeS3 implements AmazonS3 {
  AWSEngine engine;

  public HazeS3(AWSEngine engine){
    this.engine = engine;
  }

  @Override
  public void setEndpoint(String endpoint) {

  }

  @Override
  public void setRegion(Region region) throws IllegalArgumentException {

  }

  @Override
  public void setS3ClientOptions(S3ClientOptions clientOptions) {

  }

  @Override
  public void changeObjectStorageClass(String bucketName, String key, StorageClass newStorageClass) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setObjectRedirectLocation(String bucketName, String key, String newRedirectLocation) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public ObjectListing listObjects(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public ObjectListing listObjects(String bucketName, String prefix) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public ObjectListing listObjects(ListObjectsRequest listObjectsRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public ListObjectsV2Result listObjectsV2(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public ListObjectsV2Result listObjectsV2(String bucketName, String prefix) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public ListObjectsV2Result listObjectsV2(ListObjectsV2Request listObjectsV2Request) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public ObjectListing listNextBatchOfObjects(ObjectListing previousObjectListing) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public ObjectListing listNextBatchOfObjects(ListNextBatchOfObjectsRequest listNextBatchOfObjectsRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public VersionListing listVersions(String bucketName, String prefix) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public VersionListing listNextBatchOfVersions(VersionListing previousVersionListing) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public VersionListing listNextBatchOfVersions(ListNextBatchOfVersionsRequest listNextBatchOfVersionsRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public VersionListing listVersions(String bucketName, String prefix, String keyMarker, String versionIdMarker, String delimiter, Integer maxResults) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public VersionListing listVersions(ListVersionsRequest listVersionsRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public Owner getS3AccountOwner() throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public Owner getS3AccountOwner(GetS3AccountOwnerRequest getS3AccountOwnerRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public boolean doesBucketExist(String bucketName) throws AmazonClientException, AmazonServiceException {
    return false;
  }

  @Override
  public HeadBucketResult headBucket(HeadBucketRequest headBucketRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public List<Bucket> listBuckets() throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public List<Bucket> listBuckets(ListBucketsRequest listBucketsRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public String getBucketLocation(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public String getBucketLocation(GetBucketLocationRequest getBucketLocationRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public Bucket createBucket(CreateBucketRequest createBucketRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public Bucket createBucket(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public Bucket createBucket(String bucketName, com.amazonaws.services.s3.model.Region region) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public Bucket createBucket(String bucketName, String region) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public AccessControlList getObjectAcl(String bucketName, String key) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public AccessControlList getObjectAcl(String bucketName, String key, String versionId) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public AccessControlList getObjectAcl(GetObjectAclRequest getObjectAclRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void setObjectAcl(String bucketName, String key, AccessControlList acl) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setObjectAcl(String bucketName, String key, CannedAccessControlList acl) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setObjectAcl(String bucketName, String key, String versionId, AccessControlList acl) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setObjectAcl(String bucketName, String key, String versionId, CannedAccessControlList acl) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setObjectAcl(SetObjectAclRequest setObjectAclRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public AccessControlList getBucketAcl(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void setBucketAcl(SetBucketAclRequest setBucketAclRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public AccessControlList getBucketAcl(GetBucketAclRequest getBucketAclRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void setBucketAcl(String bucketName, AccessControlList acl) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setBucketAcl(String bucketName, CannedAccessControlList acl) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public ObjectMetadata getObjectMetadata(String bucketName, String key) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public ObjectMetadata getObjectMetadata(GetObjectMetadataRequest getObjectMetadataRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public S3Object getObject(String bucketName, String key) throws AmazonClientException, AmazonServiceException {
    return engine.getObject(bucketName, key);
  }

  @Override
  public S3Object getObject(GetObjectRequest getObjectRequest) throws AmazonClientException, AmazonServiceException {
    return engine.getObject(getObjectRequest.getBucketName(), getObjectRequest.getKey());
  }

  @Override
  public ObjectMetadata getObject(GetObjectRequest getObjectRequest, File destinationFile) {
    return null;
  }

  @Override
  public String getObjectAsString(String bucketName, String key) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void deleteBucket(DeleteBucketRequest deleteBucketRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void deleteBucket(String bucketName) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public PutObjectResult putObject(PutObjectRequest putObjectRequest) {
    return null;
  }

  @Override
  public PutObjectResult putObject(String bucketName, String key, File file) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public PutObjectResult putObject(String bucketName, String key, InputStream input, ObjectMetadata metadata) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public PutObjectResult putObject(String bucketName, String key, String content) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public CopyObjectResult copyObject(String sourceBucketName, String sourceKey, String destinationBucketName, String destinationKey) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public CopyPartResult copyPart(CopyPartRequest copyPartRequest) {
    return null;
  }

  @Override
  public void deleteObject(String bucketName, String key) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void deleteObject(DeleteObjectRequest deleteObjectRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public DeleteObjectsResult deleteObjects(DeleteObjectsRequest deleteObjectsRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void deleteVersion(String bucketName, String key, String versionId) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void deleteVersion(DeleteVersionRequest deleteVersionRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public BucketLoggingConfiguration getBucketLoggingConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public BucketLoggingConfiguration getBucketLoggingConfiguration(GetBucketLoggingConfigurationRequest getBucketLoggingConfigurationRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void setBucketLoggingConfiguration(SetBucketLoggingConfigurationRequest setBucketLoggingConfigurationRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public BucketVersioningConfiguration getBucketVersioningConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public BucketVersioningConfiguration getBucketVersioningConfiguration(GetBucketVersioningConfigurationRequest getBucketVersioningConfigurationRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void setBucketVersioningConfiguration(SetBucketVersioningConfigurationRequest setBucketVersioningConfigurationRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public BucketLifecycleConfiguration getBucketLifecycleConfiguration(String bucketName) {
    return null;
  }

  @Override
  public BucketLifecycleConfiguration getBucketLifecycleConfiguration(GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest) {
    return null;
  }

  @Override
  public void setBucketLifecycleConfiguration(String bucketName, BucketLifecycleConfiguration bucketLifecycleConfiguration) {

  }

  @Override
  public void setBucketLifecycleConfiguration(SetBucketLifecycleConfigurationRequest setBucketLifecycleConfigurationRequest) {

  }

  @Override
  public void deleteBucketLifecycleConfiguration(String bucketName) {

  }

  @Override
  public void deleteBucketLifecycleConfiguration(DeleteBucketLifecycleConfigurationRequest deleteBucketLifecycleConfigurationRequest) {

  }

  @Override
  public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(String bucketName) {
    return null;
  }

  @Override
  public BucketCrossOriginConfiguration getBucketCrossOriginConfiguration(GetBucketCrossOriginConfigurationRequest getBucketCrossOriginConfigurationRequest) {
    return null;
  }

  @Override
  public void setBucketCrossOriginConfiguration(String bucketName, BucketCrossOriginConfiguration bucketCrossOriginConfiguration) {

  }

  @Override
  public void setBucketCrossOriginConfiguration(SetBucketCrossOriginConfigurationRequest setBucketCrossOriginConfigurationRequest) {

  }

  @Override
  public void deleteBucketCrossOriginConfiguration(String bucketName) {

  }

  @Override
  public void deleteBucketCrossOriginConfiguration(DeleteBucketCrossOriginConfigurationRequest deleteBucketCrossOriginConfigurationRequest) {

  }

  @Override
  public BucketTaggingConfiguration getBucketTaggingConfiguration(String bucketName) {
    return null;
  }

  @Override
  public BucketTaggingConfiguration getBucketTaggingConfiguration(GetBucketTaggingConfigurationRequest getBucketTaggingConfigurationRequest) {
    return null;
  }

  @Override
  public void setBucketTaggingConfiguration(String bucketName, BucketTaggingConfiguration bucketTaggingConfiguration) {

  }

  @Override
  public void setBucketTaggingConfiguration(SetBucketTaggingConfigurationRequest setBucketTaggingConfigurationRequest) {

  }

  @Override
  public void deleteBucketTaggingConfiguration(String bucketName) {

  }

  @Override
  public void deleteBucketTaggingConfiguration(DeleteBucketTaggingConfigurationRequest deleteBucketTaggingConfigurationRequest) {

  }

  @Override
  public BucketNotificationConfiguration getBucketNotificationConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public BucketNotificationConfiguration getBucketNotificationConfiguration(GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void setBucketNotificationConfiguration(SetBucketNotificationConfigurationRequest setBucketNotificationConfigurationRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setBucketNotificationConfiguration(String bucketName, BucketNotificationConfiguration bucketNotificationConfiguration) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public BucketWebsiteConfiguration getBucketWebsiteConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public BucketWebsiteConfiguration getBucketWebsiteConfiguration(GetBucketWebsiteConfigurationRequest getBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void setBucketWebsiteConfiguration(String bucketName, BucketWebsiteConfiguration configuration) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setBucketWebsiteConfiguration(SetBucketWebsiteConfigurationRequest setBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void deleteBucketWebsiteConfiguration(String bucketName) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void deleteBucketWebsiteConfiguration(DeleteBucketWebsiteConfigurationRequest deleteBucketWebsiteConfigurationRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public BucketPolicy getBucketPolicy(String bucketName) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public BucketPolicy getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void setBucketPolicy(String bucketName, String policyText) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void setBucketPolicy(SetBucketPolicyRequest setBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void deleteBucketPolicy(String bucketName) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public void deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest) throws AmazonClientException, AmazonServiceException {

  }

  @Override
  public URL generatePresignedUrl(String bucketName, String key, Date expiration) throws AmazonClientException {
    return null;
  }

  @Override
  public URL generatePresignedUrl(String bucketName, String key, Date expiration, HttpMethod method) throws AmazonClientException {
    return null;
  }

  @Override
  public URL generatePresignedUrl(GeneratePresignedUrlRequest generatePresignedUrlRequest) throws AmazonClientException {
    return null;
  }

  @Override
  public InitiateMultipartUploadResult initiateMultipartUpload(InitiateMultipartUploadRequest request) {
    return null;
  }

  @Override
  public UploadPartResult uploadPart(UploadPartRequest request) {
    return null;
  }

  @Override
  public PartListing listParts(ListPartsRequest request) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public void abortMultipartUpload(AbortMultipartUploadRequest request) {

  }

  @Override
  public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest request) {
    return null;
  }

  @Override
  public MultipartUploadListing listMultipartUploads(ListMultipartUploadsRequest request) throws AmazonClientException, AmazonServiceException {
    return null;
  }

  @Override
  public S3ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request) {
    return null;
  }

  @Override
  public void restoreObject(RestoreObjectRequest request) throws AmazonServiceException {

  }

  @Override
  public void restoreObject(String bucketName, String key, int expirationInDays) throws AmazonServiceException {

  }

  @Override
  public void enableRequesterPays(String bucketName) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void disableRequesterPays(String bucketName) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public boolean isRequesterPaysEnabled(String bucketName) throws AmazonServiceException, AmazonClientException {
    return false;
  }

  @Override
  public void setBucketReplicationConfiguration(String bucketName, BucketReplicationConfiguration configuration) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void setBucketReplicationConfiguration(SetBucketReplicationConfigurationRequest setBucketReplicationConfigurationRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public BucketReplicationConfiguration getBucketReplicationConfiguration(String bucketName) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public BucketReplicationConfiguration getBucketReplicationConfiguration(GetBucketReplicationConfigurationRequest getBucketReplicationConfigurationRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void deleteBucketReplicationConfiguration(String bucketName) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void deleteBucketReplicationConfiguration(DeleteBucketReplicationConfigurationRequest request) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public boolean doesObjectExist(String bucketName, String objectName) throws AmazonServiceException, AmazonClientException {
    return false;
  }

  @Override
  public BucketAccelerateConfiguration getBucketAccelerateConfiguration(String bucket) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public BucketAccelerateConfiguration getBucketAccelerateConfiguration(GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest) throws AmazonServiceException, AmazonClientException {
    return null;
  }

  @Override
  public void setBucketAccelerateConfiguration(String bucketName, BucketAccelerateConfiguration accelerateConfiguration) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public void setBucketAccelerateConfiguration(SetBucketAccelerateConfigurationRequest setBucketAccelerateConfigurationRequest) throws AmazonServiceException, AmazonClientException {

  }

  @Override
  public com.amazonaws.services.s3.model.Region getRegion() {
    return null;
  }

  @Override
  public String getRegionName() {
    return null;
  }

  @Override
  public URL getUrl(String bucketName, String key) {
    return null;
  }

  @Override
  public AmazonS3Waiters waiters() {
    return null;
  }
}
