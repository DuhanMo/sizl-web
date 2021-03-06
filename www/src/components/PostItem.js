import React from 'react';
import { Card } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const PostItem = (props) => {
  const { id, title, author, modifiedDate } = props.posts;
  return (
    <div>
      <Card>
        <Card.Body>
          <Card.Title>{title}</Card.Title>
          <Card.Text>작성자 {author}</Card.Text>
          <Card.Text>최종 수정일 {modifiedDate}</Card.Text>
          <Link to={'/posts/' + id} className="btn btn-primary">
            상세보기
          </Link>
        </Card.Body>
      </Card>
      <br />
    </div>
  );
};

export default PostItem;
